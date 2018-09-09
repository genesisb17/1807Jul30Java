package com.example.hellospring;

import com.ex.hellospring.HelloWorld;

public class DependentBean {
	private HelloWorld hello;

	public DependentBean() {
		
	}
	
	
	public DependentBean(HelloWorld hello) {
		super();
		this.hello = hello;
	}

	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
	
}
