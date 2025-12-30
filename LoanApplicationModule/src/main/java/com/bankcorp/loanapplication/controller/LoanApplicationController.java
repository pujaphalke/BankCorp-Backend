package com.bankcorp.loanapplication.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.bankcorp.loanapplication.model.Documents;
import com.bankcorp.loanapplication.model.LoanApplication;
import com.bankcorp.loanapplication.service.LoanApplicationServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
@RequestMapping("/application")
public class LoanApplicationController {
	
	@Autowired
	LoanApplicationServiceI loanApplicationService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${enquiry.url}")
    private String enquiryUrl;
	
	@GetMapping("/docVerify/{customerId}")
	public ResponseEntity<String> docVerify(@PathVariable Integer  customerId)
	{
	
	
	String lsv = restTemplate.getForObject("http://localhost:9092/docVerifiedByOe", String.class);
	String status= loanApplicationService.updateLoanStatusById(customerId,lsv);
	
		return  new ResponseEntity<String>(lsv,HttpStatus.OK);
		
	}
	
	@GetMapping("/docReject/{customerId}")
	public ResponseEntity<String> docReject(@PathVariable Integer customerId)
	{
		String lsr = restTemplate.getForObject("http://localhost:9092/docRejectedByOe", String.class);
		
		String status= loanApplicationService.updateLoanStatusById(customerId,lsr);
		return  new ResponseEntity<String>(lsr,HttpStatus.OK);
	}
	
	
	
    
	@GetMapping("/getbyloanstatus/{loanStatus}")
	public ResponseEntity<List<LoanApplication>> getByLoanStatus(@PathVariable("loanStatus") String loanStatus) 
	{
		System.out.println(enquiryUrl);
		List<LoanApplication> loanApplicationRef=loanApplicationService.getByLoanStatus(loanStatus);
		return new ResponseEntity<List<LoanApplication>>(loanApplicationRef,HttpStatus.CREATED);
	}
	
	@GetMapping("/getallloanapplication")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications()
	{
		List<LoanApplication> list = loanApplicationService.getAllLoanApplications();
		return new ResponseEntity<List<LoanApplication>>(list, HttpStatus.OK);
	}
	
	@PutMapping("/update/{customerId}")
	public ResponseEntity<LoanApplication> updateLoanApplicationData(@PathVariable("customerId") Integer customerId, @RequestBody LoanApplication loanApplication)
	{
	  LoanApplication loanApplicationRef =	loanApplicationService.updateLoanApplicationDetails(customerId,loanApplication);
	  return new ResponseEntity<LoanApplication>(loanApplicationRef, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<String> deleteApplication(@PathVariable("customerId")Integer customerId)
	{
		loanApplicationService.deleteApplication(customerId);
		return new ResponseEntity<String>("Application deleted", HttpStatus.OK);
	}
	
	@PostMapping(value = "/post",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> saveLoanApplication(@RequestPart("loanApplicationData") String loanApplicationData,
			      @RequestPart("addressProof") MultipartFile addressProof,
			      @RequestPart("panCard") MultipartFile panCard,
			      @RequestPart("incomeTax") MultipartFile incomeTax,
				  @RequestPart("photo") MultipartFile photo,
				  @RequestPart("addharCard") MultipartFile addharCard,
				  @RequestPart("signature") MultipartFile signature,
				  @RequestPart("bankCheque") MultipartFile bankCheque,
				  @RequestPart("salarySlips") MultipartFile salarySlips){
		
		    loanApplicationService.saveLoanApplication(loanApplicationData,addressProof,panCard, incomeTax,photo,addharCard,signature,bankCheque,salarySlips);
		
		    return new ResponseEntity<String>("Registration done Successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/getbyId/{customerId}")
	public ResponseEntity<LoanApplication> getById(@PathVariable("customerId")Integer customerId )
	{
		LoanApplication loanApplication = loanApplicationService.getById(customerId); 
		return new ResponseEntity<LoanApplication>(loanApplication, HttpStatus.OK);
	}
	
}
