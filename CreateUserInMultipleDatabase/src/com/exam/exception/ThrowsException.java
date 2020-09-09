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

			try {
				method1(null, "B");
			} catch (Exception e) {
				System.out.println("Exception is : "+e.toString());
				System.out.println("Exception msg : "+e.getLocalizedMessage());
				System.out.println("Another msg : "+ e.getMessage());
				System.out.println();
				e.printStackTrace();
			}
		
		System.out.println("Outiside main ------------------- ");
	}
	
	public static void method1(String x, String b) throws NullPointerException{
	
		
			if (x.equals("A")) {
				System.out.println("Method1 "+ x);
			}	else {
				System.out.println("Else ----------------------");
			}
		
			
		
		System.out.println("Outside print statement");
	}

}
