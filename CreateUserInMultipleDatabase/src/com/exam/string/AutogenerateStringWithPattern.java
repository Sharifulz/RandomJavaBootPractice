package com.exam.string;


public class AutogenerateStringWithPattern {
	public static void main(String[] args) {
		String prefix = "CTS"; 
		long currentTime = System.currentTimeMillis();
		String userName = prefix+Long.toString(currentTime);
		System.out.println(userName);
		//1590909457470
		//1590909475533
	}  
}