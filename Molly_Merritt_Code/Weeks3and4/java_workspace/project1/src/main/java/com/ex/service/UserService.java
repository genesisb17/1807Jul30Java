package com.ex.service;

import java.util.List;

import com.ex.dao.Dao;
import com.ex.dao.UserDao;
import com.ex.pojos.User;

public class UserService {
	
	static Dao<User, Integer> userDao = new UserDao();
	
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	public User getUser(Integer id) {
		return userDao.findOne(id);
	}
	
	public User addUser(User u) {
		// check if username and email are unique
		boolean isUniq = userDao.isUnique(u);
		if (isUniq) {
			return userDao.save(u);
		} else {
			// create custom exception?
		} return null;
	}
	
	public User updateUser(User u) {
		return userDao.update(u);
	}
	
}
