package com.ctrends.util;

import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class EncoderDecoder implements IEncoderDecoder{

	@Override
	public String encodeString(String actualString, String salt) {
		String encodableString = salt+actualString;
		String str = Base64.getEncoder().encodeToString(encodableString.getBytes());
		return str;
	}

	@Override
	public String decodeString(String encodedString, String salt) {
		String decodeFormat = "";
		if (encodedString.length() > salt.length()) {
			byte[] decodedByte = Base64.getDecoder().decode(encodedString);
			String detailString = new String(decodedByte);
			decodeFormat = detailString.substring(salt.length());
		}
		return decodeFormat;
	}

}

