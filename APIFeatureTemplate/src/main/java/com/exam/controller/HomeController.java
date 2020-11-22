package com.exam.controller;

import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {
	
	static final String SOURCE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz"; 
	static SecureRandom secureRnd = new SecureRandom();
	
	@GetMapping("/")
	public String home() {
		//return "<h1 style='color:blue; text-align:center;'>Welcome from CTrends <span style='color:red'>GIS</span> App </h1>";
		return "index.html";
	}
	
	@PostMapping("/otp")
	public String home(@RequestBody String otpValue) {
		System.out.println("Otp received ---------- > "+ otpValue);
		//return "<h1 style='color:blue; text-align:center;'>Welcome from CTrends <span style='color:red'>GIS</span> App </h1>";
		return "index.html";
	}
	
	@GetMapping("/ok")
	public String okStart() {
		
		System.out.println("5 random alphanumeric string with length 10"); 
		for (int i = 0; i < 1; i++) {
			String alpha = randomString(10);
			System.out.println(alpha);
		} 
		System.out.println("5 random alphanumeric string with length 12");
		for (int i = 0; i < 1; i++) {
			String beta = randomString(10); 
			System.out.println(beta);
		} 
		System.out.println("5 random alphanumeric string with length 20" + " generated using Apache Commons lang"); 
		for (int i = 0; i < 1; i++) { 
			String random = RandomStringUtils.randomAlphanumeric(20).toUpperCase(); 
			System.out.println(random); 
			}
		return "";
	}
	
	public static String randomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length()))); 
		return sb.toString(); 
		}

	
}
