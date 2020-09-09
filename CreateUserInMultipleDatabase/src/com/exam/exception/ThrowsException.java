package com.exam.exception;

public class ThrowsException {

	/*
	 * java.lang.* ----> Object ----> Throwable ----- (a) Exception (a1) Checked Exception, (a2) Unchecked Exception , (b)Errors
	 * 
	 * Checked exceptions == Compile Time Exception Example: FileNotFoundException, IOException
	 * 
	 * Unchecked exceptions == Runtime Exceptions Example: ArrayIndexOutOfBoundsException, NullPointerException
	 * 
	 * Errors = StackOverflow, OutOfMemory
	 * 
	 */
	public static void main(String[] args) {

			method1("B", "B");
		
		System.out.println("Outiside main ------------------- ");
	}
	
	public static void method1(String x, String b){
	
			if (x.equals("A")) {
				System.out.println("Method1 "+ x);
			}	else {
				System.out.println("Else ----------------------");
				throw new NullPointerException();
			}
		
		System.out.println("Outside print statement");
	}

}
