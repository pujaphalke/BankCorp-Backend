package com.bankcorp.loanapplication.service;

import java.util.Date;

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
		return loanApplicationRepository.save(loanApplication);
	}

}
