package com.ex.autowire;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //can use to register any bean
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