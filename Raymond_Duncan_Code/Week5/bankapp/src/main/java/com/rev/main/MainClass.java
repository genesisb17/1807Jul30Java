package com.rev.main;

import com.rev.data.UserRepository;
import com.rev.models.User;

public class MainClass {

	public static void main(String[] args) {
		UserRepository repo = new UserRepository();
		
		User u = new User();
		u.setFirstname("Raymond");
		u.setlastname("Duncan");
		u.setUsername("raydunc");
		u.setPassword("password");
		
		repo.save(u);
		System.out.println("after save");
	}
	
}
