package com.exam.string;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHashingAndEncryption {

	public static void main(String[] args) {
		String otp = "abc1234";
		MessageDigest digest;
		byte[] encodedhash;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			encodedhash = digest.digest(
					otp.getBytes(StandardCharsets.UTF_8));
			 StringBuffer hexString = new StringBuffer();
			    for (int i = 0; i < encodedhash.length; i++) {
			    String hex = Integer.toHexString(0xff & encodedhash[i]);
			    if(hex.length() == 1) hexString.append('0');
			        hexString.append(hex);
			    }
			    System.out.println(hexString.toString());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
