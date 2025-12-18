package com.bankcorp.enquiry.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankcorp.enquiry.model.Enquiry;
import com.bankcorp.enquiry.servicei.EnquiryServiceI;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	EnquiryServiceI esi;
	
	@PostMapping("/post")
	public Enquiry saveEnquiryData(@RequestBody Enquiry e)
	{
		//e.setEnquiryDate(new Date());
		Enquiry enquiryData= esi.saveEnquiryData(e);
		return enquiryData;
	}
}
