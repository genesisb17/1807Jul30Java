package com.ex.service;

import java.util.ArrayList;
import java.util.Optional;

import com.ex.pojos.User;

public class dumbyUserService 
{
	static ArrayList<User> users = new ArrayList<User>();
	{
		users.add(new User("Zack", "admin"));
		users.add(new User("test", "test"));
		users.add(new User("username", "password"));
	}
	
	public ArrayList<User> getUsers(){
		return users;		
	}
	
	public User getByUsername(String name)
	{
		User u = users.stream().filter(x -> x.getUsername().equals(name)).findAny().orElse(null);
		return u;
	}
}
