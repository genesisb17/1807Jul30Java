package com.ex.main;

import com.ex.data.UserRepository;
import com.ex.models.User;

public class App {

	public App() {
	
	}
	
	public static void main(String[] args){
		
		UserRepository repo = new UserRepository();
		User u = new User();
		u.setFirstName("Ken");
		u.setLastName("B");
		u.setUsername("kchea");
		u.setPassword("1234");
		
		repo.save(u);
		
		System.out.println(repo.findByUsernameCriteria("kchea"));
	}

}
