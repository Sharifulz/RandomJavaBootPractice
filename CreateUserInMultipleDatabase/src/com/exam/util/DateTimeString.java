package com.exam.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
	
	public static Map<String, Object> getCurrentTimeAndExpiredTime(){
		
		Map<String, Object> map = new HashMap<>();
		Date currentDate = new Date(System.currentTimeMillis());
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		Date expiredDate = new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5));
		System.out.println("Expired Date -------> "+ expiredDate);
		
		System.out.println("Expired Time before adding 5 minute -------> "+ currentTime);
		currentTime.setTime(currentTime.getTime() + TimeUnit.MINUTES.toMillis(5));
		System.out.println("Expired Time after adding 5 minute -------> "+ currentTime);
		
		map.put("expiredDate", expiredDate);
		map.put("expiredTime", currentTime);
		return map;
		
	}
	
}
