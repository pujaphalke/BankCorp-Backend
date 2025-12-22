package com.bankcorp.loanapplication.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankcorp.loanapplication.model.LoanApplication;
import com.bankcorp.loanapplication.repository.LoanApplicationRepository;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationServiceI{
	@Autowired
	LoanApplicationRepository loanApplicationRepository;

	@Override
	public LoanApplication saveLoanApplicationData(LoanApplication loanApplication) {
		
		loanApplication.setApplicationDate(new Date());
		loanApplication.setLoanStatus("Application Submitted");
		return loanApplicationRepository.save(loanApplication);
	}

	@Override
	public List<LoanApplication> getAllApprovedApplications() {
		
		return loanApplicationRepository.findAll();
	}

	@Override
	public void deleteApplication(Integer customerId) {
		loanApplicationRepository.deleteById(customerId);		
	}

}
