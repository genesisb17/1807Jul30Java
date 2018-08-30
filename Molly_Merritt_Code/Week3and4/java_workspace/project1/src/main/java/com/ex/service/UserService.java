package com.ex.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.dao.Dao;
import com.ex.dao.UserDao;
import com.ex.dao.UserInfoDao;
import com.ex.pojos.User;
import com.ex.pojos.UserInformation;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserService {

	private static Dao<User, Integer> userDao = new UserDao();
	private static Dao<UserInformation, Integer> userInfoDao = new UserInfoDao();

	// 1. Read the request body (JSON) and set it to the `json` String variable
	// 2. Using the ObjectMapper, map the json into an object of type User
	// 3. Perform rest of logic that requires a User POJO
	public static UserInformation login(HttpServletRequest req, HttpServletResponse resp) {
		ObjectMapper mapper = new ObjectMapper(); // take json and marshall it into a pojo
		User user = null;
		try {
			user = mapper.readValue(req.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		User authorized = ((UserDao) userDao).getUser(user.getUsername());
		if (((UserDao) userDao).getPasswordHash(user).equals(authorized.getPassword())) {
			return ((UserDao) userDao).getUserInformation(user.getUsername());
		}
		return null;
	}

	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	public User getUser(Integer id) {
		return userDao.findOne(id);
	}
	
	public UserInformation getUserInfo(String username) {
		return ((UserInfoDao) userInfoDao).findOne(username);
	}
	
	public UserInformation getUserInfo(Integer id) {
		return userInfoDao.findOne(id);
	}
	
	public UserInformation addUser(UserInformation u) {
		// check if username and email are unique
		boolean isUniq = userInfoDao.isUnique(u);
		if (isUniq) {
			return userInfoDao.save(u);
		} else {
			// create custom exception?
		}
		return null;
	}

}

//package com.ex.service;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.ex.dao.Dao;
//import com.ex.dao.UserDao;
//import com.ex.pojos.User;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ex.pojos.UserInformation;
//
//public class UserService {
//	
//	static Dao<User, Integer> userDao = new UserDao();
//	
//	public List<User> getAllUsers() {
//		return userDao.findAll();
//	}
//	
//	public User getUser(Integer id) {
//		return userDao.findOne(id);
//	}
//	
//	public User addUser(User u) {
//		// check if username and email are unique
//		boolean isUniq = userDao.isUnique(u);
//		if (isUniq) {
//			return userDao.save(u);
//		} else {
//			// create custom exception?
//		} return null;
//	}
//	
//	public User updateUser(User u) {
//		return userDao.update(u);
//	}
//	
//	public static UserInformation login(HttpServletRequest req, HttpServletResponse resp) {
//		ObjectMapper mapper = new ObjectMapper();	// take json and marshall it into a pojo
//		User user = null;
//		try {
//			user = mapper.readValue(req.getReader(), User.class);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		User authorized = userDao.getUser(user.getUsername());
//		if (userDao.getPasswordHash(user).equals(authorized.getPassword())) {
//			return userDao.getUserInformation(user.getUsername());
//		} return null;
//	}
//	
//}
