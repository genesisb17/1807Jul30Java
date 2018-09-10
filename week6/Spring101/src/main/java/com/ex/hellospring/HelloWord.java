package com.ex.hellospring;

public class HelloWord {
	private String message;

	public HelloWord(String message) {
		super();
		this.message = message;
		System.out.println("this is in my constructor with some args.");
	}
	
	public HelloWord() {
		System.out.println("This is in my no args constructor.");
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("In my setter.");
	}
	
}
