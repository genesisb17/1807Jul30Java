package com.ex.autowire;

import org.springframework.stereotype.Component;
/*
 * Intro to spring sterotype annotations 
 * @compenent - can be used to register any class as a bean
 * @Service - use for business logic layer. does NOT indicate a web service
 * @Repository - use for DAO layer
 */


@Component //can use to register any bean
public class department 
{
	private String name;
	
	public department() {}

	public department(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "department [name=" + name + "]";
	}
}
