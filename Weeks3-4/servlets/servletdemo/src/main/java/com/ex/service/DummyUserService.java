package com.ex.service;

import java.util.ArrayList;

import com.ex.pojos.User;


public class DummyUserService {

	public DummyUserService() {
		// TODO Auto-generated constructor stub
	}
	
	static ArrayList<User> users = new ArrayList<User>();
	{
		users.add(new User("Darius", "none"));
		users.add(new User("testuser", "123"));
		users.add(new User("Jane", "abc"));
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	//STREAM MAGIC
	public User getByUsername(String name) {
		User u = users.stream().filter( x -> 
		x.getUsername().equals(name)).findAny().orElse(null);
		return u;
	}
}
