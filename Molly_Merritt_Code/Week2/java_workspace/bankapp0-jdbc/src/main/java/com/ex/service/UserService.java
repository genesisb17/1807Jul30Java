package com.ex.service;

import java.util.List;

import com.ex.dao.Dao;
import com.ex.dao.UserDao;
import com.ex.pojos.Users;

public class UserService {
	
	static UserDao uDao = new UserDao();
	
	public List<Users> getAllUsers() {
		return uDao.findAll();
	}
	public Users getUser(String username, String password) {
		return uDao.findOne(username, password);
	}
	
	public Users addUser(Users u) {
//		System.out.println("Calling uService.addUser");
		// check if username is already in use
		
		// add user using DAO
		return uDao.save(u);
	}

}
