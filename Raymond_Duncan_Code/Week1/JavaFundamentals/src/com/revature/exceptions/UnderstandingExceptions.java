package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class UnderstandingExceptions {

	public static void main(String[] args) {
		
		String file = "test.txt";
		try {
			FileWriter write = new FileWriter(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("At the end of the first risky code block");
		
		try {
			exploreStack(args);	//Running this shows the concept of a stack trace.
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Caught exception " + e);
		}
		
		System.out.println("At the end of the second risky code block");
		
		try {
			throwingCustom("I have an issue");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("I caught my custom exception");
		}
		
		System.out.println("At the end of the third risky code block");
	}
	
	static void doThings(String[] args) throws IOException {	//throw allows you to throw an exception
		try {	//MUST use either a catch, finally, or both
			System.out.println(args[0].toLowerCase());
			throw new IOException(); //allows you to throw a new exception
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Caught IOException");
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			aiobe.printStackTrace();
			System.out.println("Caught AIOBException");
		}
	}
	
	static void exploreStack(String[] args) throws Exception{
		doThings(args);
		System.out.println("About to throw a new Exception");
		throw new Exception();
	}
	
	static void throwingCustom(String issue) throws MyException {
		String message = "This is our problem: " + issue;
		throw new MyException(message);
	}

}
