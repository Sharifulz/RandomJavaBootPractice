package com.exam.collection;

import java.util.ArrayList;
import java.util.List;

public class LoopingListStream {

	public static void main(String[] args) {
		List<String> data = new ArrayList<>();
		StringBuilder msg = new StringBuilder("Hellow,"); //Hellow fname lname alive
		data.add(" fname");
		data.add(" lname");
		data.add(" alive");
		
		data.forEach(m->{
			msg.append(m);
		});

		System.out.println("------------ "+msg);
	}
	
}
