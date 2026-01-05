package com.bankcorp.customer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class GuarantorDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer guarantorId;
	private String guarantorName;
	private String guarantorDateOfBirth;
	private String guarantorRelationwithCustomer;
	private Long guarantorMobileNo;
	private Long guarantoraadharNo;
	private String guarantormortgageDetails;
	private String guarantorJobDetails;
	private String guarantorLocalAddress;
	private String guarantorPermanentAddress;
	
	
	
}
