package com.bankcorp.enquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		Enquiry enquiryData= esi.saveEnquiryData(e);
		return enquiryData;
	}
	
	@GetMapping("/getbyid/{customerId}")
	public ResponseEntity<Enquiry> getEnquiryById(@PathVariable Integer customerId) 
	{
	    Enquiry enquiry = esi.getEnquiryById(customerId);
	    return new ResponseEntity<Enquiry>(enquiry,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Enquiry>> getAllEnquiries() {
	    List<Enquiry> enquiry = esi.getAllEnquiries();
	    return new ResponseEntity <List<Enquiry>>(enquiry, HttpStatus.OK);
	}
	
	



}
