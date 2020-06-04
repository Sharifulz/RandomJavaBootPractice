package com.exam.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.util.EmailService;

@Service
public class ProcessEmail implements IProcessEmail {

	@Autowired
	EmailService emailService;
	
	@Override
	public Map<String, Object> sendEmailTo(String to) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		String resetCode = "123456789"+"121212";
		String subject = "Password Reset Code";
		String body = "Your request for password reset is approved, please use <span style='color:red'>"
						+resetCode+"</span> as your password reset code";

		try {
			emailService.sendMail(to, subject, body);
			String message = "A password reset code was sent on your mail address";
			data.put("data", to);
			data.put("message", message);
			data.put("responseCode", "200");
			data.put("status", "successful");
		} catch (MessagingException e) {
			data.put("data", to);
			data.put("message", e.getLocalizedMessage());
			data.put("responseCode", "404");
			data.put("status", "failure");
			e.printStackTrace();
		}
		
		return data;
	}

}
