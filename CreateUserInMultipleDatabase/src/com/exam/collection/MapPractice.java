package com.exam.collection;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {

	public static void main(String[] args) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("fname",	"Selim");
		data.put("lname",	"Khan");
		data.put("alive",	false);
		
		
		data.forEach((k,v)->{
			System.out.println("[Key]-------->"+ k+" [Value]----------> "+ v);
		});
		System.out.println("-====================================");
		data.remove("fname");
		data.forEach((k,v)->{
			System.out.println("[Key]-------->"+ k+" [Value]----------> "+ v);
		});
		
		if (data.get("alive").equals(true)) {
			//System.out.println(data.get("fname"));
		}
		
		String a[] = new String[] { "A", "B", "C", "D" }; 
		
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals("C")) {
				//System.out.println("C found");
				return;
			}
			//System.out.println(a[i]);
		}
		
	}

}
