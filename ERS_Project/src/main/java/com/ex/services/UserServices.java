package com.ex.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.dao.UserDao;
import com.ex.dao.UserDaoImp;
import com.ex.pojos.User;
import com.ex.pojos.UserInformation;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserServices {
	
	private static UserDao userDao = UserDaoImp.getInstance();
	
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
