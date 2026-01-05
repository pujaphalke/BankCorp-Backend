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
public class PermanentAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer permanentAddressId;
	private String areaName;
	private String cityName;
	private String district;
	private String state;
	private Long pincode;
	private Integer houseNumber;
	private String streetName;
	
}
