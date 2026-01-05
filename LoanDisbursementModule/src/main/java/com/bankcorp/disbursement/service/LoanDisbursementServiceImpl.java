package com.bankcorp.disbursement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankcorp.disbursement.model.LoanDisbursement;
import com.bankcorp.disbursement.repository.LoanDisbursementRepository;

@Service
public class LoanDisbursementServiceImpl implements LoanDisbursementServiceI{

	@Autowired
	LoanDisbursementRepository loanDisbursementRepository;
	
	@Override
	public void saveDisbursementData(LoanDisbursement loanDisbursement) {
		
		loanDisbursement.setAgreementDate(new Date());
		loanDisbursementRepository.save(loanDisbursement);	
	}

	@Override
	public LoanDisbursement getLoanDisbursementDataById(Integer agreementId) {
		
		LoanDisbursement loanDisbursement = loanDisbursementRepository.findById(agreementId).get();
		return loanDisbursement;
	}

	@Override
	public List<LoanDisbursement> getAllLoanDisbursement() {
		
		List<LoanDisbursement> loanDisbursement = loanDisbursementRepository.findAll();
		return loanDisbursement; 
	}

}
