package com.revature.exceptions;

public class MyException extends Exception {

	public MyException(String message) {
		super(message);
		System.out.println("Hello from inside my exception");
	}

	
	
}
