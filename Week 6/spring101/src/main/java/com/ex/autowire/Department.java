package com.ex.autowire;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*
 * Intro to spring stereotype annotations
 * @Component - can be used to register any class as a bean
 * @Service - use for business logic layer. does NOT indicated a web service
 * @Repository - use for DAO layer 
 */

@Component //can use to register any bean
@Scope("protype")
public class Department {
	private String name;

	public Department() {
		
	}
	
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
