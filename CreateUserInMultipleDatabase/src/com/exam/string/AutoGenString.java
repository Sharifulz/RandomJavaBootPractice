package com.exam.string;

import java.security.SecureRandom;
import java.util.Random;

public class AutoGenString {
	private static final Random generator = new Random();
	static final String SOURCE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz"; 
	static SecureRandom secureRnd = new SecureRandom();
	public static void main(String[] args) { 
		System.out.println("5 random alphanumeric string with length 10"); 
		for (int i = 0; i < 5; i++) {
			String alpha = randomString(10);
			System.out.println(alpha);
		} 
		System.out.println("5 random alphanumeric string with length 12");
		for (int i = 0; i < 5; i++) {
			String beta = randomString(10); 
			System.out.println(beta);
		} 
		System.out.println("5 random alphanumeric string with length 20" + " generated using Apache Commons lang"); 
		for (int i = 0; i < 5; i++) { 
			//String random = RandomStringUtils.randomAlphanumeric(20).toUpperCase(); 
			System.out.println(""); 
			} 
		} 
	public static String randomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length()))); 
		return sb.toString(); 
		}

}
