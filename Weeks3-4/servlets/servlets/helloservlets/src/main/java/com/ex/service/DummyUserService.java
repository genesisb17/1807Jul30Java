package com.ex.service;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.ex.pojos.User;

public class DummyUserService {
	/*
	 * Dummy Service layer simulating data persistence
	 */
	
	static ArrayList<User> users = new ArrayList<User>();
	{
		users.add(new User("Genesis", "admin"));
		users.add(new User("testuser", "123"));
		users.add(new User("Jane", "abc"));
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	//STREAM MAGIC -- more at https://www.mkyong.com/java8/java-8-streams-filter-examples/
	public User getByUsername(String name) {
		User u = users.stream().filter( x -> 
		x.getUsername().equals(name)).findAny().orElse(null);
		return u;
	}
	

}
