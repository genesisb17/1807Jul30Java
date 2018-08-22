package com.rev.service;

import java.util.ArrayList;

import com.rev.pojos.User;

public class DummyUserService {

	static ArrayList<User> users = new ArrayList<User>();
	{
		users.add(new User("Raymond","admin"));
		users.add(new User("testuser","123"));
		users.add(new User("JaneDoe","abc"));
		users.add(new User("MrT","pitydafoo"));
		
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	//STREAM MAJIC!
	public User getByUsername(String name) {
		User user = users.stream().filter(u -> u.getUsername().equals(name)).findAny().orElse(null);
		return user;
	}
	
	public User getbyUsername(String name) {
		User user = null;
		for(User u:getUsers()) {
			if(u.getUsername() == name) {
				user = u;
				break;
			}
		}
		return user;
	}
}
