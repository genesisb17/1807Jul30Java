package com.ex.service;

import java.util.ArrayList;
import java.util.Optional;

import com.ex.pojos.User;

public class DummyUserService {
	
	static ArrayList<User> users = new ArrayList<User>();
	{
		users.add(new User("Kenneth", "admin"));
		users.add(new User("Marie", "employee"));
		users.add(new User("Kennedy", "lolipops"));
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public User getByUsername(String name) {
		User u = users.stream().filter(w ->
			w.getUsername().equals(name)).findAny().orElse(null);
			return u;
	}
}
