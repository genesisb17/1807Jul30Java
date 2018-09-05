package com.ex.hellospring;

public class HelloWorld {
	
	private String message;

	public HelloWorld() {
		System.out.println("in no args constructor");
	}
	
	public HelloWorld(String message) {
		super();
		this.message = message;
		
		System.out.println("in message constructor");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		
		System.out.println("in setMessage()");
	}
	
	

}
