package com.bankcorp.sanction.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.bind.annotation.RestController;

import com.bankcorp.sanction.model.Sanction;
import com.bankcorp.sanction.service.SanctionServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/sanction")
@RestController
public class SanctionController {
	
	@Autowired
	SanctionServiceI sanctionService;
	
	@PostMapping(value = "/save",
		    consumes = MediaType.APPLICATION_JSON_VALUE,
		    produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Sanction> saveSanctionData(@RequestBody Sanction sanction )
	{ 
		Sanction sanctionRef = sanctionService.saveSanctionData(sanction);
		return new ResponseEntity<Sanction>(sanctionRef,HttpStatus.CREATED) ;
	}
	
	@GetMapping("/getbyId/{sanctionId}")
	public ResponseEntity<Sanction> getSanctionDataById(@PathVariable("sanctionId") Integer sanctionId)
	{
		Sanction sanction = sanctionService.getSanctionDataById(sanctionId);
		return new ResponseEntity<Sanction>(sanction,HttpStatus.OK);
	}
	
	@GetMapping("/acceptsanction/{sanctionId}")
	public ResponseEntity<Sanction> acceptSanctionLetter(@PathVariable("sanctionId") Integer sanctionId)
	{
		Sanction sanction = sanctionService.acceptLoanStatus(sanctionId);
		return new ResponseEntity<Sanction>(sanction,HttpStatus.OK);
	}
	
	@GetMapping("/rejectsanction/{sanctionId}")
	public ResponseEntity<Sanction> rejectSanctionLetter(@PathVariable("sanctionId") Integer sanctionId)
	{
		Sanction sanction = sanctionService.rejectLoanStatus(sanctionId);
		return new ResponseEntity<Sanction>(sanction,HttpStatus.OK);
	}
	
	@GetMapping("/getbyLoanStatus/{loanStatus}")
	public ResponseEntity<List<Sanction>> getAllSanctioned(@PathVariable("loanStatus")String loanStatus)
	{
		List<Sanction> list = sanctionService.getSanctionedbyLoanStatus(loanStatus);
		return new ResponseEntity<List<Sanction>>(list, HttpStatus.OK);
	}

}
