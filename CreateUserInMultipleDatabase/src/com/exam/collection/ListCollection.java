package com.exam.collection;

import java.util.ArrayList;
import java.util.List;

public class ListCollection {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		list1.add("Hellow");
		list1.add("Shariful");
		
		list2.add("World");
		list2.add("Islam");
		/*
		for (String list : list1) {
			System.out.println("Value: "+ list);
		}
		*/
		if (list2.get(0).equals("World")) {
			list2.remove(0);
		}
		for (String list : list2) {
			System.out.println("Value: "+ list);
		}
	}
}
