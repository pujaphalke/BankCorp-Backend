package com.bankcorp.enquiry.servicei;

import com.bankcorp.enquiry.model.Enquiry;

public interface EnquiryServiceI {

	Enquiry saveEnquiryData(Enquiry e);

	Enquiry updateEnquiryData(int customerId, Enquiry enquiry);

}
