package com.ex.beans;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String name;
	private String password;
	private String aboutMe;
	
	public User() {}

	public User(String name, String password, String aboutMe) {
		super();
		this.name = name;
		this.password = password;
		this.aboutMe = aboutMe;
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

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
}
