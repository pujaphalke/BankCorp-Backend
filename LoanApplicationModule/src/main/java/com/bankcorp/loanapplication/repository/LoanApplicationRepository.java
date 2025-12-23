package com.bankcorp.loanapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bankcorp.loanapplication.model.LoanApplication;

import jakarta.transaction.Transactional;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Integer>{

	
	public List<LoanApplication> findByLoanStatus(String loanStatus); 
	
	@Modifying
	@Transactional
	@Query("update LoanApplication set loanStatus=:ls where customerId=:cid")
	public void updateLoanStatus(@Param("cid") Integer customerId,@Param("ls") String loanStatus);
}
