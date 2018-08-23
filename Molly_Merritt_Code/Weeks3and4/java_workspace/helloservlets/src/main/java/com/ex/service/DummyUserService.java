package com.ex.service;

import java.util.ArrayList;
import java.util.Optional;

import com.ex.pojos.User;

public class DummyUserService {
	
	static ArrayList<User> users = new ArrayList<User>();
	
	{
		users.add(new User("Genesis", "admin"));
		users.add(new User("testuser", "123"));
		users.add(new User("Jane", "abc"));
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	// STREAM MAGIC
	// think of streams as some sort of collection that may or may not have values that we can use lambdas with
	public User getByUsername(String name) {
		User u = users.stream().filter(x -> x.getUsername().equals(name)).findAny().orElse(null);
		return u;
	}

}