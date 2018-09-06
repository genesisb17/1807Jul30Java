package com.ex.beans;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String name;
	private String password;
	private String aboutme;
	
	public User() {}

	public User(String name, String password, String aboutme) {
		super();
		this.name = name;
		this.password = password;
		this.aboutme = aboutme;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}
	
	

}
