package com.ex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ex.beans.User;

@Service
public class UserService {
	
	//MOCK SERVICE LAYER. WOULD ACTUALLY TALK TO A DAO IN A REAL APPLICATION
	
	static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("Genesis", "123", "i am awesome"));
		users.add(new User("Ravi", "pass", "I am the boss"));
	}
	
	public List<User> getAll() {
		return users;
	}
	
	public User login(String username, String password) {
		Optional<User> user = users.stream().filter(u -> u.getName().equalsIgnoreCase(username)).findFirst();
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
}
