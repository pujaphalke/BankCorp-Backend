package com.bankcorp.oe.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("*")
@RestController
public class OEController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/cibil")
	public Integer checkCibil()
	{
		  Integer cibilScore =
		            ThreadLocalRandom.current().nextInt(300, 901);

		return cibilScore;
	}
	
	@GetMapping("/docVerifiedByOe")
	public String docVerified()
	{
		String loanStatus = "DocVerified";
		
		return loanStatus;
	}
	
	@GetMapping("/docRejectedByOe")
	public String docRejected()
	{
		String loanStatus = "DocRejected";
		
		return loanStatus;
	}
	
	
	
	
	
}
