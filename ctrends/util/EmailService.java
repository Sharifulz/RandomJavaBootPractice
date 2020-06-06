package com.ctrends.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EmailService implements IEmailService {

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	@Async
	public void sendMail(String to, String subject, String body) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message, true);
		
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true);
		
		try {
			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
