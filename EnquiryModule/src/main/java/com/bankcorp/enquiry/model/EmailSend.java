package com.bankcorp.enquiry.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailSend {

	private String toEmail;
	private String fromEmail;
	private String subject;
	private String message;
	
}
