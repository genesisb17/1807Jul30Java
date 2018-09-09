package com.ex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ex.beans.User;

@Service
public class UserService {
	//mockservice layer. would talk to dao
	//when the block is loaded its added to the memory
	static ArrayList<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("Kenneth", "2134", "i am awesome"));
		users.add(new User("Danielle", "4555", "she is awesome"));
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User login(String username, String password) {
		Optional<User> user = users.stream().filter(u->
			u.getName().equalsIgnoreCase(username)).findFirst();
		if(user.isPresent()) {
			if(user.get().getPassword().equals(password)) {
				return user.get();
			}
		}
		return null;
	}
}
