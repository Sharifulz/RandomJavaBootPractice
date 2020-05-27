package com.ctrends;

public class LatLongMain {

	public static void main(String[] args) {
		
		final int R = 6371;
		
		double lat1 = 23.8210963;
		double lat2 = 23.8210983;
		
		double lng1 =  90.401298;
		double lng2 = 	90.401278;
		
		double deltaLat = Math.toRadians(lat2 - lat1);
		double deltaLng = Math.toRadians(lng2 - lng1);
		
		double a = Math.pow(Math.sin(deltaLat/2), 2) + Math.cos(Math.toRadians(lat1) * Math.cos(lat2))* Math.pow(Math.sin(deltaLng/2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = R *c;

		System.out.println("Result is -------------- "+ d);
	}

}
