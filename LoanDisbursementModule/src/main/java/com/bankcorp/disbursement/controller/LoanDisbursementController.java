package com.bankcorp.disbursement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankcorp.disbursement.model.LoanDisbursement;
import com.bankcorp.disbursement.service.LoanDisbursementServiceI;
@CrossOrigin("*")
@RestController
@RequestMapping("/disbursement")
public class LoanDisbursementController {

	@Autowired
	LoanDisbursementServiceI loanDisbursementService;
	
	@PostMapping("/save")
	public  ResponseEntity<String> saveDisbursementData(@RequestBody LoanDisbursement loanDisbursement )
	{ 
		loanDisbursementService.saveDisbursementData(loanDisbursement);
		return new ResponseEntity<String>("Disbursement data saved",HttpStatus.CREATED) ;
		
	}
	

	@GetMapping("/getById/{agreementId}")
	public ResponseEntity<LoanDisbursement> getLoanDisbursementDataById(@PathVariable("agreementId") Integer agreementId)
	{
		
		LoanDisbursement loanDisbursement = loanDisbursementService.getLoanDisbursementDataById(agreementId);
		return new ResponseEntity<LoanDisbursement>(loanDisbursement,HttpStatus.OK);
	}
	

	@GetMapping("/get")
	public ResponseEntity<List<LoanDisbursement>> getAllLoanDisbursement()
	{
		List<LoanDisbursement> list = loanDisbursementService.getAllLoanDisbursement();
		return new ResponseEntity<List<LoanDisbursement>>(list, HttpStatus.OK);
	}
}
