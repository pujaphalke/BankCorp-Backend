package com.bankcorp.sanction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankcorp.sanction.model.Sanction;

@Repository
public interface SanctionRepository extends JpaRepository<Sanction, Integer> {

	public List<Sanction> getByLoanStatus(String loanStatus);
}
