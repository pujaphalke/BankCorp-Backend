package com.bankcorp.sanction.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping(
		    value = "/save",
		    consumes = MediaType.APPLICATION_JSON_VALUE,
		    produces = MediaType.APPLICATION_JSON_VALUE
		)
	public  ResponseEntity<Sanction> saveSanctionData(@RequestBody Sanction sanction )
	{ 
		
		Sanction sanctionRef = sanctionService.saveSanctionData(sanction);
		
		return new ResponseEntity<Sanction>(sanctionRef,HttpStatus.CREATED) ;
		
	}
	
	@GetMapping("/get/{sanctionId}")
	public ResponseEntity<Sanction> getSanctionDataById(@PathVariable("sanctionId") Integer sanctionId)
	{
		System.out.println("");
		Sanction sanction = sanctionService.getSanctionDataById(sanctionId);
		return new ResponseEntity<Sanction>(sanction,HttpStatus.OK);
	}

}
