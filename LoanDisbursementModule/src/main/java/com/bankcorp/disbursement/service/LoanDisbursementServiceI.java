package com.bankcorp.disbursement.service;

import java.util.List;

import com.bankcorp.disbursement.model.LoanDisbursement;

public interface LoanDisbursementServiceI {

	public LoanDisbursement saveDisbursementData(LoanDisbursement loanDisbursement);

	public LoanDisbursement getLoanDisbursementDataById(Integer agreementId);

	public List<LoanDisbursement> getAllLoanDisbursement();
}
