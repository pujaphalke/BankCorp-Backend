package com.bankcorp.customer.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerAddressId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "permanent_address_id",nullable = false)
    private PermanentAddress permanentAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "local_address_id", nullable = false)
	private LocalAddress localAddress;
    
    
}
