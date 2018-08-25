package com.revature.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImp;
import com.revature.model.User;
import com.revature.model.UserInformation;

public class UserService {
	
	private static UserDao userDao = UserDaoImp.getInstance();
	
	// 1. Read the Request body (JSON), and set it to the 'json' String variable
	// 2. Using the ObjectMapper, map the json into an an object type User
	// 3. Perform rest of logic that requires a User POJO
	public static UserInformation login(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		
		try {
			user = mapper.readValue(request.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		User authorized = userDao.getUser(user.getUsername());
		if (userDao.getPasswordHash(user).equals(authorized.getPassword()))
			return userDao.getUserInformation(user.getUsername());
		return null;
	}
}
