package com.ex.hellospring;

public class DependentBean {
	private helloWorld hello;

	public DependentBean() {}
	
	public DependentBean(helloWorld hello) {
		super();
		this.hello = hello;
	}

	public helloWorld getHello() {
		return hello;
	}

	public void setHello(helloWorld hello) {
		this.hello = hello;
	}
	
	

}
