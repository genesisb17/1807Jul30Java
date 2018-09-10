package com.ex.service;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.beans.User;

@Service
public class UserService {

	//mock service layer. would talk to DAO
	
	static ArrayList<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("Genesis", "123", "i am awesome"));
		users.add(new User("Ravi", "pass", "I am the boss"));
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User login(String username, String password) {
		Optional<User> user = users.stream().filter(u -> u.getName().equalsIgnoreCase(username)).findFirst();
		if(user.isPresent()) {
			if(user.get().getPassword().equals(password)) {
				return user.get();
			}
		}
		return null;
	}
}