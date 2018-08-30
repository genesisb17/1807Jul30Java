package com.ex.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.dao.UserDao;
import com.ex.pojos.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserService {

	static UserDao uDao = new UserDao();

	public User findUser(String username) {
		return uDao.findOne(username);
	}

	public User findUser(String username, String password) {
		return uDao.findOne(username, password);
	}

	public User addUser(User u) {
		return uDao.save(u);
	}

	public List<User> findAllUsers() {
		return uDao.findAll();
	}

	// 1. Read the request body (JSON) and set it to the `json` String variable
	// 2. Using the ObjectMapper, map the json into an object of type User
	// 3. Perform rest of logic that requires a User POJO
	public static User login(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("logging in");
		ObjectMapper mapper = new ObjectMapper(); // take json and marshall it into a pojo
		User user = null;
		try {
			user = mapper.readValue(req.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		User authorized = uDao.findOne(user.getUsername());
		System.out.println(user);		// just username and password (everything else is null)
		System.out.println(authorized);	// all user information
		if (uDao.getPasswordHash(user).equals(authorized.getPassword())) {
			System.out.println("returning authorized");
			return authorized;
		}
		return null;
	}

}
