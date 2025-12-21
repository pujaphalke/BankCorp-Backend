package com.bankcorp.enquiry.model;

import java.util.Date;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String loanStatus;
	private String email;
	private Long mobileNo;
	private String pancardNo;
	@Temporal(TemporalType.DATE)
	private Date enquiryDate;
	@OneToOne(cascade = CascadeType.ALL)
	private Cibil cibil;
}
