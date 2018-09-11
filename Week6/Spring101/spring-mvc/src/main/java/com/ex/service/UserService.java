package com.ex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.beans.User;

@Service
public class UserService {
	//mock service layer. would talk to dao
	
	static ArrayList<User> users = new ArrayList<User>();
	
	@Autowired
	private UserService service;
	
	static {
		users.add(new User("Samwise", "test", "Handyman"));
		users.add(new User("Gobbler", "test", "Handyturkey"));
	}
	
	public List<User> getAll() {
		return users;
	}

	
	public User login(String username, String password) {
		Optional<User> user = users.stream().filter(u -> u.getName().equalsIgnoreCase(username)).findFirst();
		if(user.isPresent()) {
			if(user.get().getPassword().equals(password)) {
				return user.get();
			}
		}
		return null; //wrong credentials
	}
}
