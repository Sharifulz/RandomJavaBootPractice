package com.exam.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListCollection {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("A");
		list1.add("B");
		list1.add("B");
		list1.add("B");
		list1.add("C");
		int size = list1.size();
		/*
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).equals("B")) {
				list1.remove(i);
				size--;
			}
		}
		*/
		/*
		for (String string : list1) {
			if (string.equals("B")) {
				list1.remove(string);
			}
		}
		*/
		
		List<String> resultList = list1.stream().filter(str->!str.equals("B")).collect(Collectors.toList());
		
//		 Numbers.removeIf(n -> (n % 3 == 0));
		 
		 
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
		
	}
}
