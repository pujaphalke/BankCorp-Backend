package com.bankcorp.sanction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SanctionModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanctionModuleApplication.class, args);
	}
	@Bean
     public RestTemplate restTeamplate()
     {
		return new RestTemplate();
     }
}
