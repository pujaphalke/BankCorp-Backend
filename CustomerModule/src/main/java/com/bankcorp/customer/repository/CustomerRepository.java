package com.bankcorp.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankcorp.customer.model.LoanApplication;

@Repository
public interface CustomerRepository extends JpaRepository<LoanApplication, Integer> {

}
