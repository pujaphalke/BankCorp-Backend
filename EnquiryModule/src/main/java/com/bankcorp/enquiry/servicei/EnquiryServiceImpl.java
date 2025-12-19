package com.bankcorp.enquiry.servicei;

import java.util.Date;

import java.util.Optional;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankcorp.enquiry.model.Enquiry;
import com.bankcorp.enquiry.repository.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI{

	@Autowired
	EnquiryRepository enquiryRepository;

	@Override

	public Enquiry saveEnquiryData(Enquiry enquiry) {
		enquiry.setEnquiryDate(new Date());
		return enquiryRepository.save(enquiry);
	}

	@Override
	public Enquiry updateEnquiryData(int customerId, Enquiry enquiry) {
		
		Optional<Enquiry> enquiryRef = enquiryRepository.findById(customerId);
		
		if(enquiryRef.isPresent())
		{
			Enquiry enquiryUpdatedData = enquiryRef.get();
			enquiryUpdatedData.setFirstName(enquiry.getFirstName());
			enquiryUpdatedData.setLastName(enquiry.getLastName());
			enquiryUpdatedData.setAge(enquiry.getAge());
			enquiryUpdatedData.setEmail(enquiry.getEmail());
			enquiryUpdatedData.setMobileNo(enquiry.getMobileNo());
			enquiryUpdatedData.setPancardNo(enquiry.getPancardNo());
			
			return enquiryRepository.save(enquiryUpdatedData);
		}else{
			
			return null;
		}
		
		

	public Enquiry saveEnquiryData(Enquiry e) {
		e.setEnquiryDate(new Date());
	
		return er.save(e);

	}

	@Override
	public Enquiry getEnquiryById(Integer customerId) {
		
		return er.findById(customerId).get();
	}
	
	@Override
	public List<Enquiry> getAllEnquiries() {
	    return er.findAll();
	}
}
