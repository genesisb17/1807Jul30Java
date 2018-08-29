package com.ers.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.UserDao;
import com.ers.dao.UserDaoImpl;
import com.ers.pojo.User;
import com.ers.pojo.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserService {
private static UserDao userDao = UserDaoImpl.getInstance();
	
	public static UserInfo login(HttpServletRequest req, HttpServletResponse resp) {
		ObjectMapper mapper = new ObjectMapper();
		
		User user = null;
		try {
			
			user = mapper.readValue(req.getReader(), User.class);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		User authorized = userDao.getUser(user.getUsername());
		if(userDao.getPasswordHash(user).equals(authorized.getPassword()))
			return userDao.getUserInfo(user.getUsername());
		return null;
	}
	
	
}
