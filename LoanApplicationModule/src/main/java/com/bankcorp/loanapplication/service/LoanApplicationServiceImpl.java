package com.bankcorp.loanapplication.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bankcorp.loanapplication.model.Documents;
import com.bankcorp.loanapplication.model.LoanApplication;
import com.bankcorp.loanapplication.model.LoanDisbursement;
import com.bankcorp.loanapplication.model.Sanction;
import com.bankcorp.loanapplication.model.Sanction;
import com.bankcorp.loanapplication.repository.LoanApplicationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationServiceI{

	@Autowired
	LoanApplicationRepository loanApplicationRepository;
    
	@Autowired
	JavaMailSender mailSenderUtility;
	


	@Override
	public List<LoanApplication> getAllLoanApplications() {
		
		return loanApplicationRepository.findAll();
	}

	@Override
	public void deleteApplication(Integer customerId) {
		loanApplicationRepository.deleteById(customerId);		
	}

	

	@Override
	public LoanApplication updateLoanApplicationDetails(Integer customerId, LoanApplication loanApplication) {
		Optional<LoanApplication> loanApplicationRef = loanApplicationRepository.findById(customerId);
		if(loanApplicationRef.isPresent())
		{
			LoanApplication loanApplicationData = loanApplicationRef.get();
			loanApplicationData.setFirstName(loanApplication.getFirstName());
			loanApplicationData.setLastName(loanApplication.getLastName());
			loanApplicationData.setAge(loanApplication.getAge());
			loanApplicationData.setCustomerGender(loanApplication.getCustomerGender());
			loanApplicationData.setEmail(loanApplication.getEmail());
			loanApplicationData.setMobileNo(loanApplication.getMobileNo());
			loanApplicationData.setPancardNo(loanApplication.getPancardNo());
			loanApplicationData.setLoanTenure(loanApplication.getLoanTenure());
			loanApplicationData.setLoanRequired(loanApplication.getLoanRequired());
			
			return loanApplicationRepository.save(loanApplicationData);
				
			
		}
		return null;
	}

	@Override
	public void saveLoanApplication(String  loanApplicationData, MultipartFile addressProof, MultipartFile panCard,
			                        MultipartFile incomeTax, MultipartFile photo, MultipartFile addharCard,
			                        MultipartFile signature, MultipartFile bankCheque, MultipartFile salarySlips)
	{
		
		        ObjectMapper objectMapper = new ObjectMapper();
				Documents document = new Documents();
				LoanApplication loanApplication = new LoanApplication();

             try {
				
					loanApplication = objectMapper.readValue(loanApplicationData, LoanApplication.class);
					
				    document.setAddressProof(addressProof.getBytes());
					document.setPanCard(panCard.getBytes());
					document.setIncomeTax(incomeTax.getBytes());
					document.setAddharCard(addharCard.getBytes());
					document.setPhoto(photo.getBytes());
					document.setSignature(signature.getBytes());
					document.setBankCheque(bankCheque.getBytes());
					document.setSalarySlips(salarySlips.getBytes());
					loanApplication.setApplicationDate(new Date());
					loanApplication.setLoanStatus("Submitted");
					loanApplication.setDocuments(document);
					
					loanApplicationRepository.save(loanApplication);
					
					SimpleMailMessage mailMessage = new SimpleMailMessage();
					mailMessage.setTo(loanApplication.getEmail());
					mailMessage.setFrom("pujaphalke1997@gmail.com");
					mailMessage.setSubject("Loan Application Submitted...");
					mailMessage.setText("ThanqnYou, "
							+ "Wait Util your next process we will inform you shortly"
							+ "Thanks&Reagards"
							+ "BankCorp Bank");
					mailSenderUtility.send(mailMessage);
				} catch(IOException e) {
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}
		}

	@Override
	public List<LoanApplication> getByLoanStatus(String loanStatus) {
		
		
		return loanApplicationRepository.findByLoanStatus(loanStatus);
	}

	@Override
	public String updateLoanStatusById(Integer customerId,String loanStatus) {
	  	 loanApplicationRepository.updateLoanStatus(customerId, loanStatus);
		
		
		return loanStatus;
	}

	@Override
	public LoanApplication getById(Integer customerId) {
	
		
		return  loanApplicationRepository.findById(customerId).get();
	}

	@Override
	public LoanApplication updateSanctionData(Integer customerId, Sanction sanctionData)
	{
		LoanApplication loanApplication = loanApplicationRepository.findById(customerId).get();
	
		  double p = sanctionData.getLoanAmountSanctioned();
		  double annualRate = sanctionData.getRateOfInterest();
		  int n = sanctionData.getLoanTenure();
		  double r = annualRate/(12*100);
		  
		  double emi = (p * r * Math.pow(1+r, n) )/
				       (Math.pow(1+r, n));
		  sanctionData.setMonthlyEmiAmount(emi);
		  
		  loanApplication.setSanction(sanctionData);
		
		loanApplication.setLoanStatus("SanctionGenerated");
		return loanApplicationRepository.save(loanApplication);
	}

	@Override
	public LoanApplication updateDisbursementData(Integer customerId, LoanDisbursement loanDisbursementRef) {
		
		LoanApplication loanApplication=loanApplicationRepository.findById(customerId).get();
		
		loanDisbursementRef.setLoanAmountSanctioned(loanApplication.getSanction().getLoanAmountSanctioned());
		
		Double totalAmount = loanDisbursementRef.getLoanAmountSanctioned();
		
		Double remainingAmount = totalAmount - loanDisbursementRef.getTransferAmount();
		loanApplication.setLoanDisbursement(loanDisbursementRef);
		
		loanApplication.setLoanStatus("Disbursed");
		
		return loanApplicationRepository.save(loanApplication);
	}

}
