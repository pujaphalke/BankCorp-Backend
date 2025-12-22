package com.bankcorp.loanapplication.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	private Integer customerAddressId;
	@OneToOne(cascade = CascadeType.ALL)
    private PermanentAddress permanentAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private LocalAddress localAddress;
    
    
}
