package com.iantimothyjohnson.notes.week6;

public class DependentBean {
	// This dependency will be injected (or "wired") by the Spring controller.
	private HelloWorld hello;
	
	public DependentBean() {
	}

	public DependentBean(HelloWorld hello) {
		this.hello = hello;
	}

	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
}
