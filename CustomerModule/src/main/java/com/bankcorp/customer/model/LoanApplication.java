package com.bankcorp.customer.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class LoanApplication 
{
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
	
	@OneToOne(cascade = CascadeType.ALL)
	private Documents documents;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private CustomerAddress customerAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private DependantInfo dependantInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AccountDetails accountDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantorDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sanction_id")
	private Sanction sanction;
	
}
