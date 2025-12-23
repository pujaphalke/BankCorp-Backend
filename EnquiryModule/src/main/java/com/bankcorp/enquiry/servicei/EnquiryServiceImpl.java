package com.bankcorp.enquiry.servicei;

import java.util.Date;

import java.util.Optional;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankcorp.enquiry.model.Cibil;
import com.bankcorp.enquiry.model.EmailSend;
import com.bankcorp.enquiry.model.Enquiry;
import com.bankcorp.enquiry.repository.EnquiryRepository;


@Service
public class EnquiryServiceImpl implements EnquiryServiceI{

	@Autowired
	EnquiryRepository enquiryRepository;
	
	@Autowired
	JavaMailSender mailSenderUtility;
	
	@Override
    public Enquiry saveEnquiryData(Enquiry enquiry) {
		enquiry.setEnquiryDate(new Date());
		enquiry.setLoanStatus("Pending");
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(enquiry.getEmail());
			mailMessage.setFrom("gonyalshubham0@gmail.com");
			mailMessage.setSubject("Enquiry Submitted...");
			mailMessage.setText("Enquiry Submitted");
			mailSenderUtility.send(mailMessage);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		 
		return enquiryRepository.save(enquiry);
	}

	@Override
	public Enquiry updateEnquiryData(int customerId, Enquiry enquiry) {
		
		Optional<Enquiry> enquiryRef = enquiryRepository.findById(customerId);
		
		if(enquiryRef.isPresent())
		{
			Enquiry enquiryUpdatedData = enquiryRef.get();
			enquiryUpdatedData.setFirstName(enquiry.getFirstName());
			enquiryUpdatedData.setLastName(enquiry.getLastName());
			enquiryUpdatedData.setAge(enquiry.getAge());
			enquiryUpdatedData.setEmail(enquiry.getEmail());
			enquiryUpdatedData.setLoanRequired(enquiry.getLoanRequired());
			enquiryUpdatedData.setLoanTenure(enquiry.getLoanTenure());
			enquiryUpdatedData.setCustomerGender(enquiry.getCustomerGender());
			enquiryUpdatedData.setMobileNo(enquiry.getMobileNo());
			enquiryUpdatedData.setPancardNo(enquiry.getPancardNo());
			
			return enquiryRepository.save(enquiryUpdatedData);
		}else{
			
			return null;
		}
	}

	@Override
	public Enquiry getEnquiryById(Integer customerId) 
	{
		return enquiryRepository.findById(customerId).get();
	}
	
	@Override
	public List<Enquiry> getAllEnquiries() 
	{
	    return enquiryRepository.findAll();
	}

	@Override
	public Enquiry updateCibil(Integer customerId, Integer cibilscore) 
	{
		Enquiry enquiry = enquiryRepository.findById(customerId).get();
		
		enquiry.setLoanStatus("Forward To Operational Executive");
		
		Cibil cibil = new Cibil();
		
		
		cibil.setCibilScore(cibilscore);
		cibil.setCibilScoreDate(new Date());
		if(cibilscore>=300 && cibilscore<=579)
		{
			cibil.setCibilStatus("Rejected");
			cibil.setCibilRemark("Poor");
		}else if (cibilscore>=580 && cibilscore<=669)
		{
			cibil.setCibilStatus("Approved");
			cibil.setCibilRemark("Fair");
		}else if(cibilscore>=670 && cibilscore<=739)
		{
			cibil.setCibilStatus("Approved");
			cibil.setCibilRemark("Good");
		}else if(cibilscore>=740 && cibilscore<=799)
		{
			cibil.setCibilStatus("Approved");
			cibil.setCibilRemark("Very Good");
		}else if(cibilscore>=800 && cibilscore<=900)
		{
			cibil.setCibilStatus("Approved");
			cibil.setCibilRemark("Excellent");
		}
		enquiry.setCibil(cibil);
		
		//score remark status
		if(cibil.getCibilStatus().equals("Approved"))
		{
			enquiry.setLoanStatus("CibilApproved");
			try {
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(enquiry.getEmail());
				mailMessage.setFrom("gonyalshubham0@gmail.com");
				mailMessage.setSubject("Cibil Score Check");
				mailMessage.setText("Cibil Score:"+cibil.getCibilScore()+" Cibil Status: "+cibil.getCibilStatus()+"Cibil Remark:"+cibil.getCibilRemark()+"Your Application is Approved.You are eligible for Home Loan ,prepare Your documents IncomeTax details,AadharCard,PanCard And Submit As Soon As Possible for further Process.");
				mailSenderUtility.send(mailMessage);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		}else{ 
			try {
				enquiry.setLoanStatus("CibilRejected");
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(enquiry.getEmail());
			mailMessage.setFrom("gonyalshubham0@gmail.com");
			mailMessage.setSubject("Cibil Score Check");
			mailMessage.setText("Cibil Score:"+cibil.getCibilScore()+" Cibil Status: "+cibil.getCibilStatus()+"Cibil Remark:"+cibil.getCibilRemark()+"Your Application is Rejected,Try After one MONTH .");
			mailSenderUtility.send(mailMessage);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return enquiryRepository.save(enquiry);
	}

	@Override
	public void deleteEnquiryData(int customerId) {
		
		enquiryRepository.deleteById(customerId);
	}

	@Override
	public void forwardToOe( int customerId) {
	 Enquiry enquiry=	enquiryRepository.findById(customerId).get();
	 enquiry.setLoanStatus("forwardToOE");
	 enquiryRepository.save(enquiry);
	}

	@Override
	public List<Enquiry> getByLoanStatus(String loanStatus) {
		List<Enquiry> enquirylist = enquiryRepository.getByLoanStatus(loanStatus);
        return (List<Enquiry>) enquirylist;
    }
}
