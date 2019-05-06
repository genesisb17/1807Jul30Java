package com.ex.hellospring;

public class helloWorld {

	private String message;

	
	public helloWorld() {
		
		System.out.println("in no arg constructor");
		
	}
	
	public helloWorld(String message) {
		super();
		this.message = message;
		System.out.println("in args constructor");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("in sMessage ");
	}
	
	
}
