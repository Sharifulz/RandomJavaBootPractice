package com.exam.exception;

public class ThrowsException {

	public static void main(String[] args) {
		
		try {
			method1(null, "B");
		} catch (Exception e) {
			System.out.println("Inside main -----------------------------");
			e.printStackTrace();
		}
		System.out.println("Outiside main ------------------- ");
	}
	
	public static void method1(String x, String b){
		try {
			if (x.equals("A")) {
				System.out.println("Method1 "+ x);
			}	
		} catch (Exception e) {
			System.out.println("Exception method 1");
			e.printStackTrace();
		}
		
		System.out.println("Outside print statement");
	}

}
