package com.ex.service;

import java.util.List;
import java.util.ArrayList;

import com.ex.beans.User;

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
}
