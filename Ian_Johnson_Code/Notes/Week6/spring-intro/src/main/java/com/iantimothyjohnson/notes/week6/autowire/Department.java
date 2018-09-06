package com.iantimothyjohnson.notes.week6.autowire;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Intro to Spring stereotype annotations.

@Component
@Scope("prototype")
public class Department {
	private String name = "Marketing";
	
	public Department() {
	}

	public Department(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
