package com.bankcorp.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bankcorp.customer.model.LoanApplication;
import com.bankcorp.customer.model.Sanction;
import com.bankcorp.customer.service.CustomerServiceI;

@CrossOrigin("*")
@RequestMapping("/customer")
@RestController
public class CustomerController 
{
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CustomerServiceI customerService;
	
	
	@GetMapping("/getsanction/{customerId}")
	public ResponseEntity<Sanction> getSanctionData(@PathVariable("customerId") Integer customerId)
	{
		LoanApplication loanApplicationRef = restTemplate.getForObject("http://localhost:9093/application/getbyId/"+customerId, LoanApplication.class);
		Sanction sanctionRef = restTemplate.getForObject("http://localhost:9094/sanction/getbyId/"+loanApplicationRef.getSanction().getSanctionId(), Sanction.class);
		return new ResponseEntity<Sanction>(sanctionRef,HttpStatus.OK);
	}
	
	@GetMapping("/accept/{customerId}")
	public ResponseEntity<LoanApplication> acceptLoanStatus(@PathVariable("customerId") Integer customerId)
	{
		LoanApplication loanApplication= customerService.acceptLoanStatus(customerId);
		return new ResponseEntity<LoanApplication>(loanApplication,HttpStatus.OK);
	}
	
	@GetMapping("/reject/{customerId}")
	public ResponseEntity<LoanApplication> rejectLoanStatus(@PathVariable("customerId") Integer customerId)
	{
		LoanApplication loanApplication= customerService.rejectLoanStatus(customerId);
		return new ResponseEntity<LoanApplication>(loanApplication,HttpStatus.OK);
	}
	
}
