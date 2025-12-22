package com.bankcorp.loanapplication.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bankcorp.loanapplication.model.LoanApplication;
import com.bankcorp.loanapplication.service.LoanApplicationServiceI;


@RestController
@RequestMapping("/application")
public class LoanApplicationController {
	
	@Autowired
	LoanApplicationServiceI loanApplicationService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${enquiry.url}")
    private String enquiryUrl;
	
    
	@GetMapping("/getbyLoanStutus/{loanStatus}")
	public ResponseEntity<List<LoanApplication>> saveLoanApplicationData(@PathVariable("loanStatus") String loanStatus) 
	{
		System.out.println(enquiryUrl);
		List<LoanApplication> loanApplicationRef=restTemplate.getForObject(enquiryUrl+"/"+loanStatus,List.class);
		return new ResponseEntity<List<LoanApplication>>(loanApplicationRef,HttpStatus.CREATED);
	}
	
	@GetMapping("/getallApprovedApplications")
	public ResponseEntity<List<LoanApplication>> getAllApprovedApplications()
	{
		List<LoanApplication> list = loanApplicationService.getAllApprovedApplications();
		return new ResponseEntity<List<LoanApplication>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<String> deleteApplication(@PathVariable("customerId")Integer customerId)
	{
		loanApplicationService.deleteApplication(customerId);
		return new ResponseEntity<String>("Application deleted", HttpStatus.OK);
	}
}
