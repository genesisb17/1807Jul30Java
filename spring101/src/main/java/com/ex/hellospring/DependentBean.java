package com.ex.hellospring;

public class DependentBean {
	
	private HelloWorld hello;

	public HelloWorld getHello() {
		return hello;
	}
	
	public DependentBean() {}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}

	public DependentBean(HelloWorld hello) {
		super();
		this.hello = hello;
	}

	
	
}
