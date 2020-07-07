package com.exam.string;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.exam.util.DateTimeString;

public class DateTimeFormatString {
	public static void main(String[] args) {
		/*
		LocalDateTime myDateObj = LocalDateTime.now();  
	    DateTimeFormatter date = DateTimeFormatter.ofPattern("dd MMM, yyyy");  
	    DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss a");  
	    String formattedDate = myDateObj.format(date);  
	    String formattedTime = myDateObj.format(time);  
	    System.out.println("Date:  " + formattedDate);  
	    System.out.println("Time:  " + formattedTime);  
	    */
		System.out.println(DateTimeString.getDate());
		System.out.println(DateTimeString.getTime());
	}
	
}
