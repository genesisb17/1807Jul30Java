package com.ex.main;

import com.ex.beans.User;
import com.ex.data.UserRepository;

public class Main {

	public Main() {
		UserRepository repo = new UserRepository();
		
		User u = new User();
		u.setFirstName("Sam");
		u.setLastName("E");
		u.setUsername("seang");
		u.setPassword("123");
		
		repo.save(u);
	}
	
}
