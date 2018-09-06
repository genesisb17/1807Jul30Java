package com.ex.hellospring;

public class HelloWorld {
	private String message;

	public HelloWorld() {
		super();
		System.out.println("IN NO ARGS CONSTR");
	}

	public HelloWorld(String message) {
		super();
		this.message = message;
		System.out.println("IN MESSAGE CONSTR");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("IN SETTER METHOD");
	}
	
	
}
