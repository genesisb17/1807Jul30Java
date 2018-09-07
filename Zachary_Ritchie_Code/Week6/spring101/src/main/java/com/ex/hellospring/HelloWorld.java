package com.ex.hellospring;

public class HelloWorld 
{
	private String message;
	
	public HelloWorld()
	{
		System.out.println("In No Args Constructor (Default)");
	}
	
	@Override
	public String toString() {
		return "HelloWorld [message=" + message + "]";
	}



	public HelloWorld(String message) {
		super();
		this.message = message;
		System.out.println("In message contructor");
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("In setmessage");
	}
	
	
}
