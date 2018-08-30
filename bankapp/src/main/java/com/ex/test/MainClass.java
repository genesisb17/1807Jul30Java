package com.ex.test;

import com.ex.models.User;
import com.ex.repository.UserRepository;

public class MainClass {

	public static void main(String[] args) {
		UserRepository repo = new UserRepository();
		
		User u = new User();
		u.setFirstName("Gen");
		u.setLastName("B");
		u.setUsername("gb");
		u.setPassword("123");
		
		repo.save(u);
		
		System.out.println(repo.findByUsername("GB"));
	}
}
