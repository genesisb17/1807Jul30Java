package com.ex.hellospring;

public class dependentBean
{
	private HelloWorld hello;
	
	public dependentBean()	{}

	
	
	public dependentBean(HelloWorld hello) {
		super();
		this.hello = hello;
	}

	@Override
	public String toString() {
		return "dependentBean [hello=" + hello + "]";
	}

	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
	
	
}
