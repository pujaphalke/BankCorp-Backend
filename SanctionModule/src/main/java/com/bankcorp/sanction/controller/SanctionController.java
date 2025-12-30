package com.bankcorp.sanction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.bind.annotation.RestController;

import com.bankcorp.sanction.model.Sanction;
import com.bankcorp.sanction.service.SanctionServiceI;

@RequestMapping("/sanction")
@RestController
public class SanctionController {
	
	@Autowired
	SanctionServiceI sanctionService;
	
	@PostMapping("/save")
	public  ResponseEntity<String> saveSanctionData(@RequestBody Sanction sanction )
	{ 
		sanctionService.saveSanctionData(sanction);
		return new ResponseEntity<String>("Sancton data save",HttpStatus.CREATED) ;
		
	}
	
	@GetMapping("/get/{sanctionId}")
	public ResponseEntity<Sanction> getSanctionDataById(@PathVariable("sanctionId") Integer sanctionId)
	{
		Sanction sanction = sanctionService.getSanctionDataById(sanctionId);
		return new ResponseEntity<Sanction>(sanction,HttpStatus.OK);
	}

}
