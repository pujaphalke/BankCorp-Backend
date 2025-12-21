package com.bankcorp.loanapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("/post")
	public ResponseEntity<LoanApplication> saveLoanApplicationData(@PathVariable("loanStatus") String loanStatus  ,@RequestBody LoanApplication loanApplication) {
		
		
		LoanApplication loanApplicationRef=restTemplate.postForObject(enquiryUrl+"/"+loanStatus,loanApplication,LoanApplication.class);
		LoanApplication loanApplicationData=loanApplicationService.saveLoanApplicationData(loanApplicationRef);
		return new ResponseEntity<LoanApplication>(loanApplicationData,HttpStatus.CREATED);
		
		
	}
}
