package com.revature.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.model.User;
import com.revature.model.UserInformation;

public class UserService {

	private static UserDao userDao = UserDaoImpl.getInstance();
	
	public static UserInformation login(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		try {
			user = mapper.readValue(request.getReader(), User.class); //take to a mapper, feeding in the json, and mapping it to our user class
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User authorized = userDao.getUser(user.getUsername());
		if (userDao.getPasswordHash(user).equals(authorized.getPassword()))
			return userDao.getUserInformation(user.getUsername());
		return null;
	}
}
