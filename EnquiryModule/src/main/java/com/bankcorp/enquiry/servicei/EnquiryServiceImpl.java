package com.bankcorp.enquiry.servicei;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankcorp.enquiry.model.Enquiry;
import com.bankcorp.enquiry.repository.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI{

	@Autowired
	EnquiryRepository er;

	@Override
	public Enquiry saveEnquiryData(Enquiry e) {
		e.setEnquiryDate(new Date());
		return er.save(e);
	}

	
	@Override
	public void deleteEnquiryData(int customerId) {
		
		er.deleteById(customerId);
		
	}
}
