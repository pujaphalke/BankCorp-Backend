package com.bankcorp.enquiry.servicei;

import java.util.List;

import com.bankcorp.enquiry.model.Enquiry;

public interface EnquiryServiceI {

	public Enquiry saveEnquiryData(Enquiry e);
	
	public Enquiry getEnquiryById(Integer customerId);
	
	public List<Enquiry> getAllEnquiries();

	public Enquiry updateEnquiryData(int customerId, Enquiry enquiry);

	public Enquiry updateCibil(Integer customerId, Integer cibilscore);

	public void deleteEnquiryData(int customerId);

}
