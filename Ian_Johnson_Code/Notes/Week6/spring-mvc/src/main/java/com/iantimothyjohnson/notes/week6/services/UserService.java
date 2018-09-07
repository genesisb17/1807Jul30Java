package com.iantimothyjohnson.notes.week6.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iantimothyjohnson.notes.week6.beans.User;

// Mock service layer; would ordinarily talk to DAO.
@Service
public class UserService {
	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User("Ian", "password", "A cool guy."));
		users.add(new User("Genesis", "trainer", "Revature trainer."));
	}

	public List<User> getAll() {
		return users;
	}

	public User getByUsername(String username) {
		return users.stream().filter(u -> u.getName().equals(username)).findAny().orElse(null);
	}

	public User login(String username, String password) {
		if (username == null || password == null) {
			System.out.println("Username or password omitted.");
			return null;
		}
		Optional<User> ou = users.stream().filter(user -> user.getName().equalsIgnoreCase(username)).findAny();
		if (!ou.isPresent()) {
			System.out.println("Wrong username.");
			return null;
		}
		User u = ou.get();
		if (!u.getPassword().equals(password)) {
			System.out.println("Wrong password.");
			return null;
		}
		System.out.println("Logged in!");
		return u;
	}
}
