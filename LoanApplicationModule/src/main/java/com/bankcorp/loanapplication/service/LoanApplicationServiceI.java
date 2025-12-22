package com.bankcorp.loanapplication.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bankcorp.loanapplication.model.LoanApplication;

public interface LoanApplicationServiceI {

	

	public List<LoanApplication> getAllLoanApplications();

	public void deleteApplication(Integer customerId);

	public LoanApplication updateLoanApplicationDetails(Integer customerId, LoanApplication loanApplication);
	
	public void saveLoanApplication(String loanApplication,MultipartFile addressProof,MultipartFile panCard,MultipartFile incomeTax,MultipartFile photo,MultipartFile addharCard,MultipartFile signature,MultipartFile bankCheque,MultipartFile salarySlips);

}
