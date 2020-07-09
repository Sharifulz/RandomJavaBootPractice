package com.exam.string;

import java.util.ArrayList;
import java.util.List;

import com.exam.oop.Project;

public class AutogenerateStringWithPattern {
	public static void main(String[] args) {
		/*String prefix = "CTS"; 
		long currentTime = System.currentTimeMillis();
		String userName = prefix+Long.toString(currentTime);
		System.out.println(userName);
		//1590909457470
		//1590909475533
		*/
		
		String fileName = "eq.jpg";
		String[] splitArr = fileName.split("\\.");
		//System.out.println(splitArr.length);
		
		for (String string : splitArr) {
			//System.out.println(string);
		}
		
		String unions="";
		
		Project p1 = new Project("BDA", "BDAWIFI1", "Bangladesh Army Wifi Project");
		Project p2 = new Project("BDA", "BDAWIFI2", "Bangladesh Army Wifi Project");
		Project p3 = new Project("CTS", "BDAWIFI3", "CTrends Software Limited");
		Project p4 = new Project("BDA", "SURVEY4", "Bangladesh Army Survey Project");
		Project p5 = new Project("BDA", "BDAWIFI5", "Bangladesh Army Wifi Project");
		
		List<Project> projectList = new ArrayList<Project>();
		projectList.add(p1);
		projectList.add(p2);
		projectList.add(p3);
		projectList.add(p4);
		projectList.add(p5);
		
		for (Project project : projectList) {
			//unions +=project.getProjectCode() +", ";
		}
		
		//String msg = unions.substring(0, unions.length()-2);
		//System.out.println(unions.length());
		//System.out.println(msg);
		//System.out.println(msg);
		
		String str = "BDADHTH00311";
		//String lastFOur = str.substring(str.length()-4);
		int inDecimal = Integer.parseInt(str.substring(str.length()-4), 10)+1;
		//int finalNumer = inDecimal+1;
		String str2 = String.format("%04d", inDecimal);
		System.out.println(str2);
		/*
		long lst = 00172;
		System.out.println(lst);
		 
		System.out.println(Integer.parseInt(str,10));
		*/
		/*
		int actualDigitsLength = String.valueOf(lst).length();
		System.out.println("Nunber is "+ lst + " ----- Digit Length : "+ actualDigitsLength);
		if (actualDigitsLength<5) {
			String addZero = "";
			for (int i = 0; i < 4-actualDigitsLength; i++) {
				System.out.println("loop");
				addZero+="0";
			}
			//System.out.println(addZero+String.valueOf(lst4+1));
		}
		*/
		
		String abc = "Hey there";
		
		String[] abcd = abc.split(" ");
		
		System.out.println(abc);
		
		
	}  
}
