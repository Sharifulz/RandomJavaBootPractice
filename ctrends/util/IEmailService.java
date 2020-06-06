package com.ctrends.util;

import javax.mail.MessagingException;

public interface IEmailService {
	public void sendMail(String to, String subject, String body) throws MessagingException;
}
