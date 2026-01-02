package com.bankcorp.sanction.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankcorp.sanction.model.Sanction;
import com.bankcorp.sanction.repository.SanctionRepository;

import tools.jackson.databind.ObjectMapper;

@Service
public class SanctionServiceImpl implements SanctionServiceI {

	@Autowired
	SanctionRepository sanctionRepository;
	
	@Override
	public Sanction saveSanctionData(Sanction sanction) {
		
		
 		
	    sanction.setSanctionDate(new Date());
	     sanction.setLoanStatus("SanctionGenerated");
	     sanction.setTermsCondition("Standard");
	      
	      
	      
	    return  sanctionRepository.save(sanction);
         
		
		
	}

	@Override
	public Sanction getSanctionDataById(Integer sanctionId) {
		System.out.println("");
		return sanctionRepository.findById(sanctionId).get();
	}

}
