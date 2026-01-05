package com.bankcorp.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankcorp.customer.model.LoanApplication;
import com.bankcorp.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerServiceI 
{
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public LoanApplication acceptLoanStatus(Integer customerId) 
	{
		
		LoanApplication loanApplicationRef = customerRepository.findById(customerId).get();
		loanApplicationRef.setLoanStatus("SanctionAccepted");
		loanApplicationRef.getSanction().setLoanStatus("SanctionAccepted");
		return customerRepository.save(loanApplicationRef);
	}

	@Override
	public LoanApplication rejectLoanStatus(Integer customerId) 
	{
		LoanApplication loanApplicationRef = customerRepository.findById(customerId).get();
		loanApplicationRef.setLoanStatus("SanctionRejected");
		loanApplicationRef.getSanction().setLoanStatus("SanctionRejected");
		return customerRepository.save(loanApplicationRef);
	}

}
