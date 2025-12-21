package com.bankcorp.enquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankcorp.enquiry.model.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{
	
	public Enquiry getByLoanStatus(String loanStatus);

}
