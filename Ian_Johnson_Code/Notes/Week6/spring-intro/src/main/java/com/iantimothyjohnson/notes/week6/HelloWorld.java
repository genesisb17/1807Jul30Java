package com.iantimothyjohnson.notes.week6;

public class HelloWorld {
	private String message;
	
	public HelloWorld() {
		System.out.println("In HelloWorld no-args constructor.");
	}
	
	public HelloWorld(String message) {
		this.message = message;
		System.out.println("In HelloWorld one-arg constructor.");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("In setMessage.");
	}
}
