package com.bankcorp.loanapplication.service;

import java.util.List;

import com.bankcorp.loanapplication.model.LoanApplication;

public interface LoanApplicationServiceI {

	public LoanApplication saveLoanApplicationData(LoanApplication loanApplication);

	public List<LoanApplication> getAllApprovedApplications();

	public void deleteApplication(Integer customerId);

}
