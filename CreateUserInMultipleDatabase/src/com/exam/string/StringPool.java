package com.exam.string;

public class StringPool {

	public static void main(String[] args) {
		String s1 = "Apple";
		String s2 = "Mango";
		String s3 = "Apple";
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println("Is s1.equals(s2)? "+ s1.equals(s2));
		System.out.println("Is s1.equals(s3)? "+ s1.equals(s3));
	}

}
