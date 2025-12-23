package com.bankcorp.loanapplication.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class DependantInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dependantInfoId;
	private Integer noOfFamilyMembers;
	private Integer noOfChild;
	private String maritalStatus;
	private List<String> dependantMember;
	private double familyIncome;
	
}
