package com.exam.collection;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {

	public static void main(String[] args) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("fname",	"Selim");
		data.put("lname",	"Khan");
		data.put("alive",	false);
		if (data.get("alive").equals(true)) {
			System.out.println(data.get("fname"));
		}
	}

}
