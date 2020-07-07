package com.exam.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeString {

	public static String date;
	public static String time;

	public static String getDate() {
		LocalDateTime myDateObj = LocalDateTime.now();  
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd MMM, yyyy");  
		String formattedDate = myDateObj.format(date);  
		return formattedDate;
	}

	public static String getTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss a");  
		 String formattedTime = myDateObj.format(time);
		return formattedTime;
	}  
	
}
