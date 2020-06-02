package com.exam.string;

import java.util.Base64;

public class Base64EncodeDecode {

	public static void main(String[] args) {
		String key = "NRBG123456789";
		
		String encodedString = Base64EncodeDecode.encodeString(key, "cts");
		System.out.println("Encoded String : "+ encodedString);
		
		String decodedString = Base64EncodeDecode.decodeString(encodedString, "cts");
		System.out.println("Decoded String : "+ decodedString);
		
		//Encoded String : Y3RzQkRBMTIzNDU2Nzg5
		//Decoded String : BDA123456789
				
		//Encoded String : Y3RzQ1RTMTIzNDU2Nzg5
		//Decoded String : CTS123456789
				
		//Encoded String : Y3RzTlJCRzEyMzQ1Njc4OQ==
		//Decoded String : NRBG123456789
	}
	
	public static String encodeString(String actualString, String salt) {
		String encodableString = salt+actualString;
		String encodeStr = Base64.getEncoder().encodeToString(encodableString.getBytes());
		return encodeStr;
	}
	
	public static String decodeString(String encodedString, String salt) {
		String decodeStr = "";
		if (encodedString.length() > salt.length()) {
			byte[] decodedByte = Base64.getDecoder().decode(encodedString);
			String detailString = new String(decodedByte);
			decodeStr = detailString.substring(salt.length());
		}
		return decodeStr;
	}
}
