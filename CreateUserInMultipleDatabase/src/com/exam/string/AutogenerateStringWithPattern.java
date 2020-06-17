package com.exam.string;


public class AutogenerateStringWithPattern {
	public static void main(String[] args) {
		/*String prefix = "CTS"; 
		long currentTime = System.currentTimeMillis();
		String userName = prefix+Long.toString(currentTime);
		System.out.println(userName);
		//1590909457470
		//1590909475533
		*/
		
		String fileName = "eq.jpg";
		String[] splitArr = fileName.split("\\.");
		System.out.println(splitArr.length);
		
		for (String string : splitArr) {
			System.out.println(string);
		}
		
	}  
}
