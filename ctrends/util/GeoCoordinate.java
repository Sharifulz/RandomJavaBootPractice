package com.ctrends.util;

import org.springframework.stereotype.Service;

@Service
public class GeoCoordinate implements IGeoCoordinate{

	@Override
	public double geoPointDifferenceInKm(double lat1, double lat2, double lng1, double lng2) {
		
		final int Radius = 6371;
		
		double deltaLat = Math.toRadians(lat2 - lat1);
		double deltaLng = Math.toRadians(lng2 - lng1);
		
		double a = Math.pow(Math.sin(deltaLat/2), 2) + Math.cos(Math.toRadians(lat1) * Math.cos(lat2))* Math.pow(Math.sin(deltaLng/2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double distance = Radius *c;

		return distance;
	}
	

	
}
