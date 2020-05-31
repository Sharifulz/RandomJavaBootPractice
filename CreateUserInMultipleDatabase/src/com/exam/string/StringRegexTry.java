package com.exam.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegexTry {
	
	private static final String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-z0-9 ]).{6,20})";
	private static final String EMAIL_PATTERN_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static void main(String[] args) {
		
		Pattern passpattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher passmatcher = passpattern.matcher("Iama!string");
		boolean b = passmatcher.find();
         
		Pattern pattern = Pattern.compile(PASSWORD_REGEX);
		Matcher matcher = pattern.matcher("Iamastring");
		if (b) {
		   System.out.println("There is a special character in my string");
		}else {
			System.out.println("There is no special character in my string");
		}
		
		//-------------------------------------------
		
		String email1 = "abcgm-11ail1@outlook.com";
		Pattern emailPattern = Pattern.compile(EMAIL_PATTERN_REGEX);
		Matcher emailMatcher = emailPattern.matcher(email1);
		boolean ismatched = emailMatcher.find();
		
		if (ismatched) {
			System.out.println("Email Valid");
		}else {
			System.out.println("Email Invalid");
		}
		
		
		String regex = "\\d{10}";
		String phone= "1969037346";
		
		if (phone.matches("\\d{10}")) {
			System.out.println("Phone Number Valid");
		}else {
			System.out.println("Phone Number invalid");
		}
	}  

	
}
