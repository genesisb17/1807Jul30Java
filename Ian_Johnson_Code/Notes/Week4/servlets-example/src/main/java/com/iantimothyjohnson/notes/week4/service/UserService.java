package com.iantimothyjohnson.notes.week4.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iantimothyjohnson.notes.week4.dao.UserDao;
import com.iantimothyjohnson.notes.week4.dao.UserDaoImpl;
import com.iantimothyjohnson.notes.week4.pojos.User;
import com.iantimothyjohnson.notes.week4.pojos.UserInformation;

public class UserService {
	private static final UserDao userDao = new UserDaoImpl();
	private static final ObjectMapper mapper = new ObjectMapper();

	public static UserInformation login(HttpServletRequest req, HttpServletResponse resp) {
		User user = null;
		try {
			user = mapper.readValue(req.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		User authorized = userDao.getUser(user.getUsername());
		if (authorized.getPassword().equals(userDao.getPasswordHash(user))) {
			// Password is correct.
			return userDao.getUserInformation(user.getUsername());
		}
		return null;
	}
}
