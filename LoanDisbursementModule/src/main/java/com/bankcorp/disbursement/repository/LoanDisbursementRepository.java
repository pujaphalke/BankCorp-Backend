package com.bankcorp.disbursement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankcorp.disbursement.model.LoanDisbursement;

@Repository
public interface LoanDisbursementRepository extends JpaRepository<LoanDisbursement, Integer>{

}
