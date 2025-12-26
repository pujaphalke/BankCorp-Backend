package com.bankcorp.oe.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class OEController {


	@GetMapping("/cibil")
	public Integer checkCibil()
	{
		  Integer cibilScore =
		            ThreadLocalRandom.current().nextInt(300, 901);

		return cibilScore;
	}
}
