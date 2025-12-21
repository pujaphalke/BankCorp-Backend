package com.bankcorp.enquiry.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.bankcorp.enquiry.model.Enquiry;
import com.bankcorp.enquiry.servicei.EnquiryServiceI;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	EnquiryServiceI enquiryService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/post")
	public ResponseEntity<Enquiry> saveEnquiryData(@RequestBody Enquiry enquiry)
	{		
		
		Enquiry enquiryData= enquiryService.saveEnquiryData(enquiry);
		
		return new ResponseEntity<Enquiry>(enquiryData, HttpStatus.CREATED);  
	}
	
	//Using RequestPart for post in enquiry 
	
	//	@PostMapping("/post")
	//	public ResponseEntity<Enquiry> saveEnquiryData(@RequestPart("data") String data)
	//	{	
	//		ObjectMapper objectMapper = new ObjectMapper();
	//		Enquiry enquiry = new Enquiry();
	//		try {
	//		enquiry = objectMapper.readValue(data, Enquiry.class);
	//		enquiryService.saveEnquiryData(enquiry);
	//		}
	//		catch(Exception e) {
	//		e.printStackTrace();  
	//		}
	//		return new ResponseEntity<Enquiry>(enquiry, HttpStatus.CREATED);
	//	}
	
	@PutMapping("/update/{customerId}")
	public ResponseEntity<Enquiry> updateEnquiryData(@PathVariable("customerId") int customerId,
			                                         @RequestBody Enquiry enquiry)
	{
	   Enquiry enquiryRef = enquiryService.updateEnquiryData(customerId , enquiry);
	   return new ResponseEntity<Enquiry>(enquiryRef, HttpStatus.OK);

	}
	
	@GetMapping("/getbyid/{customerId}")
	public ResponseEntity<Enquiry> getEnquiryById(@PathVariable Integer customerId) 
	{
	    Enquiry enquiry = enquiryService.getEnquiryById(customerId);
	    return new ResponseEntity<Enquiry>(enquiry,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Enquiry>> getAllEnquiries() 
	{
	    List<Enquiry> enquiry = enquiryService.getAllEnquiries();
	    return new ResponseEntity <List<Enquiry>>(enquiry, HttpStatus.OK);
	}
	
	@GetMapping("/updatecibil/{customerId}")
	public ResponseEntity<Enquiry> updateCibil(@PathVariable("customerId")Integer customerId)
	{
		
	    Integer cibilscore = restTemplate.getForObject("http://localhost:9092/cibil", Integer.class);
		System.out.println("CibilScore is: "+cibilscore);
		
		Enquiry enquiry = enquiryService.updateCibil(customerId,cibilscore);
        return new ResponseEntity<Enquiry>(enquiry, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{customerId}")
	public ResponseEntity<String> deleteEnquiryData(@PathVariable ("customerId") int customerId)
	{
		enquiryService.deleteEnquiryData(customerId);
		return new ResponseEntity<String>("Data is Deleted", HttpStatus.OK);
	}
	
	@GetMapping("/fto/{customerId}")
	public ResponseEntity<String> forwardToOe(@PathVariable("customerId") int customerId)
	{
	 enquiryService.forwardToOe(customerId);
	 return new ResponseEntity<String>("Forward to OE successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getByLoanStatus/{loanStatus}")
	public ResponseEntity<Enquiry> getByLoanStatus(@PathVariable("loanStatus") String loanStatus){
		
		Enquiry enquiry= enquiryService.getByLoanStatus(loanStatus);
        return new ResponseEntity<Enquiry>(enquiry, HttpStatus.OK);

		
	}
	



}
