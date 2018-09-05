package com.ex.autowire;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*
 * Intro to spring stereotype annotations
 * @Component - can be used to register any class as a bean
 * @Service - used for business logic layer. does NOT indicate a web service
 * @Repository - used for DAO layer
 */

@Component
@Scope("prototype")
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
