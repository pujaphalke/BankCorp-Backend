package com.bankcorp.enquiry.servicei;

import java.util.Date;

import java.util.Optional;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankcorp.enquiry.model.Cibil;
import com.bankcorp.enquiry.model.Enquiry;
import com.bankcorp.enquiry.repository.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI{

	@Autowired
	EnquiryRepository enquiryRepository;
	

	@Override
    public Enquiry saveEnquiryData(Enquiry enquiry) {
		enquiry.setEnquiryDate(new Date());
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
		
		return enquiryRepository.save(enquiry);
	}

	@Override
	public void deleteEnquiryData(int customerId) {
		
		enquiryRepository.deleteById(customerId);
	}
}
