package com.exam.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class PasswordService implements IPasswordService {

	@Override
	public boolean matchPassword(String password) {
		String pwd = "abc123!@#A";
		String hashedPwd ="";
		return false;
	}

	@Override
	public Map<String, Object> generateRandomPass() {
		Map<String, Object> data = new HashMap<String, Object>();
		//String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
		
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String pwd = RandomStringUtils.randomAlphanumeric(5);
		String pwd2 = RandomStringUtils.randomAlphabetic(5);
		
		System.out.println( pwd );
		
		data.put("data", pwd2);
		data.put("message", "");
		data.put("responseCode", "200");
		data.put("status", "successful");
		
		return data;
	}

}
