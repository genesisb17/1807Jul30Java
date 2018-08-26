package com.rev.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.UserDao;
import com.rev.dao.UserDaoImpl;
import com.rev.model.User;
import com.rev.model.UserInformation;

public class UserService {

	private static UserDao userDao = UserDaoImpl.getInstance();

	// 1. Read the request body (JSON) and set it to the json String variable
	// 2. Using the object mapper, map the json into an object of type User
	// 3. Perform the rest of the logic that requires a user POJO
	public static UserInformation login(HttpServletRequest req, HttpServletResponse resp) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		try {
			user = mapper.readValue(req.getReader(), User.class);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		User authorized = userDao.getUser(user.getUsername());
		if (userDao.getPasswordHash(user).equals(authorized.getPassword())) {
			return userDao.getUserInformation(user.getUsername());
		}
		return null;
	}

}
