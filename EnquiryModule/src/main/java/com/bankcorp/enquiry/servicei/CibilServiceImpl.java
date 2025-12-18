package com.bankcorp.enquiry.servicei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankcorp.enquiry.model.Cibil;
import com.bankcorp.enquiry.repository.CibilRepository;

@Service
public class CibilServiceImpl implements CibilServiceI {

	@Autowired
	CibilRepository cibilRepository;
	
	@Override
	public Cibil updateCibilData(int cibilId, Cibil c) {
		
		return cibilRepository.save(c);
	}

}
