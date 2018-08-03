package com.revature.exceptions;

import java.io.IOException;

public class UnderstandingExceptions {
	
	public static void main(String[] args) {
		// we will attempt to access the 0th index of our args array
		// System.out.println(args[0].toLowerCase());
		// if no input, this throws an ArrayIndexOutOfBoundsException
		
//		String file = "test.txt";
//		FileWriter write = new FileWriter(file);
		
		
		// whenever you're writing your own code, it's better to handle
		// exceptions in the method where the risky code is, rather than
		// throwing it and handling it later
		
		try {
			exploreStack(args);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Reached the end of main");
		
		try{
			propagate();
		} catch(MyException e) {
			System.out.println("EXCEPTION MESSAGE: " + e.getMessage());
		}
	}
	
	static void doThings(String[] args) {
		try { // MUST use either a catch, finally, or both
			System.out.println(args[0].toLowerCase());
			throw new IOException(); // allow you to throw an exception
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Caught IO exception");
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Caught index array out of bounds exception");
		}
	}
	
	static void exploreStack(String[] args) throws Exception {
		// signature indicates this method throws an exception and caller must handle it
		doThings(args);
		System.out.println("About to throw new Exception from explore stack");
		throw new Exception();
	}
	
	static void throwingCustom(String issue) throws MyException {
		String message = "This is our problem: " + issue;
		throw new MyException(message);
	}
	
	static void propagate() throws MyException {
		throwingCustom("In propagate method, calling method that throws the exception");
	}

}
