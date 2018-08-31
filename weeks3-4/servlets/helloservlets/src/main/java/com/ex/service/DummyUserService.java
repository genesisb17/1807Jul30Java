package com.ex.service;

import java.util.ArrayList;

import com.ex.pojos.User;

public class DummyUserService {
	
	static ArrayList<User> users=new ArrayList<User>();
	
	{
	users.add(new User("mike","admin"));
	users.add(new User("testuser","123"));
	users.add(new User("Jane","abc"));
	}

	
	public ArrayList<User> getUsers(){
		
		return users;
	}
	
	
	public User getByUsername(String name) {
		User u=users.stream().filter(x-> x.getUsername().equals(name)).findAny().orElse(null);
		
		return u;
	}
	}
