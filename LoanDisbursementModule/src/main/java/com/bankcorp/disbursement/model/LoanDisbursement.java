package com.bankcorp.disbursement.model;

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
public class LoanDisbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agreementId;
	
	@Temporal(TemporalType.DATE)
	private Date agreementDate;
	private String amountPayType;
	private Double totalAmount; 
	private String bankName;
	private Long accountNumber;
	private String IFSCCode;
	private String accountType;
	private Double transferAmount;
	
	private String paymentStatus;
	
}
