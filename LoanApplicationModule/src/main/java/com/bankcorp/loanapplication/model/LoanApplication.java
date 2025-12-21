package com.bankcorp.loanapplication.model;

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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class LoanApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String customerGender;
	private Integer loanTenure;
	private Double loanRequired;
	private String email;
	private Long mobileNo;
	private String pancardNo;
	private String loanStatus;
	@Temporal(TemporalType.DATE)
	private Date applicationDate;
	

}
