package com.iantimothyjohnson.notes.week4.service;

import java.util.ArrayList;

import com.iantimothyjohnson.notes.week4.pojos.User;

public class DummyUserService {
	static ArrayList<User> users = new ArrayList<>();

	static {
		users.add(new User("genesis", "admin"));
		users.add(new User("ianprime0509", "password"));
		users.add(new User("testuser", "password"));
	}

	public User getByUsername(String username) {
		return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
	}
}
