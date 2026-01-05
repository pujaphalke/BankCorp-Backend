package com.bankcorp.customer.service;

import com.bankcorp.customer.model.LoanApplication;

public interface CustomerServiceI 
{

	LoanApplication acceptLoanStatus(Integer customerId);

	LoanApplication rejectLoanStatus(Integer customerId);

}
