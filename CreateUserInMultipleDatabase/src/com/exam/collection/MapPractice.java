package com.exam.collection;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {

	public static void main(String[] args) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("name",	"Selim");
		data.put("name",	"Amina");
		
		System.out.println(data.get("name"));
	}

}
