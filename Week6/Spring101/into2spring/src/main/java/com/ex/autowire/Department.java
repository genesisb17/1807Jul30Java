package com.ex.autowire;

import org.springframework.stereotype.Component;

/*
 * Intro to spring stereotype annotations
 *  @Compnonent - can be used to register any class as a bean
 *  @Service - use for business logic layer, does NOT inficate a web service
 *  @Repository - use for DAO layer
 *
 */

@Component //can use to register any bean
public class Department {

	private String name;

	public Department() {}

	public Department(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
