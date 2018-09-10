package com.ex.hellospring;

public class DependentBean {
	
	private HelloWord hello;

	public DependentBean(HelloWord hello) {
		super();
		this.hello = hello;
	}
	
	public DependentBean() {}
	
	public HelloWord getHello() {
		return hello;
	}
	

	public void setHello(HelloWord hello) {
		this.hello = hello;
	}
	
}
