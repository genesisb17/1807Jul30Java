package com.iantimothyjohnson.notes.week5.app;

import com.iantimothyjohnson.notes.week5.data.UserRepository;

public class Driver {
	public static void main(String[] args) {
		UserRepository repo = new UserRepository();
//		User u = new User("Ian", "Johnson", "ianprime0509", "password");
//		repo.save(u);
		System.out.println(repo.findByUsernameCriteria("ianPrime0509"));
	}
}
