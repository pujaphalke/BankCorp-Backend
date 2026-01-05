package com.bankcorp.customer.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sanction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sanctionId;
	@Temporal(TemporalType.DATE)
	private Date sanctionDate;
	private String firstName;
	private String lastName;
	private Long mobileNo;
	private Double loanAmountSanctioned;
	private Float rateOfInterest;
	private Integer loanTenure;
	private Double monthlyEmiAmount;
	private String termsCondition;
	private String loanStatus;
	
	

}
