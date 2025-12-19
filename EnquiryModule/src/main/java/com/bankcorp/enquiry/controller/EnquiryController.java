package com.bankcorp.enquiry.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@DeleteMapping("/deleteById/{customerId}")
	public ResponseEntity<String> deleteEnquiryData(@PathVariable ("customerId") int customerId )
	{
		esi.deleteEnquiryData(customerId);
		return new ResponseEntity<String>("Data Is Deleted", HttpStatus.OK);
	}
}
