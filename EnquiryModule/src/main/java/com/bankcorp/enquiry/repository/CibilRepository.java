package com.bankcorp.enquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankcorp.enquiry.model.Cibil;

@Repository
public interface CibilRepository extends JpaRepository<Cibil, Integer>{

}
