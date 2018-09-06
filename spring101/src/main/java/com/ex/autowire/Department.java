package com.ex.autowire;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * Intro to spring stereotype annotations
 * @Component - can be used to register any class as a bean
 * @Service - user for business logic layer. Does NOT indicate a web service
 * @Repository - use for DAO layer
 */

@Component
@Scope("prototype")
public class Department {
	
	private String name;

	public String getName() {
		return name;
	}
	
	public Department() {}

	public void setName(String name) {
		this.name = name;
	}

	public Department(String name) {
		super();
		this.name = name;
	}

}
