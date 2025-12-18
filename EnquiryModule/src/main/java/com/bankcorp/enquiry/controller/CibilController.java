package com.bankcorp.enquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankcorp.enquiry.model.Cibil;
import com.bankcorp.enquiry.servicei.CibilServiceI;

@RequestMapping("/cibil")
@RestController
public class CibilController {

	@Autowired
	CibilServiceI service;
	
	@PutMapping("/")
	public Cibil updateCibilData(@RequestBody Cibil c,@PathVariable("cibilId") int cibilId)
	{
		Cibil cibil =service.updateCibilData(cibilId,c);
		return null;
	}
}
