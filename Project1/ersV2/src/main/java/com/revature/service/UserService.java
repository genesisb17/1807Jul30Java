package com.revature.service;

import java.util.List;
import com.revature.dao.Dao;
import com.revature.dao.DaoUser;

import com.revature.pojos.User;


public class UserService {

	static Dao<User, Integer> daouser = new DaoUser();
	
	public List<User> getAllUsers(){
		return daouser.getAll();
	}
	
	public User addUser(User u) {
		return daouser.save(u);
	}
	
	public User getOneUser(String s) {
		return daouser.findOne(s);
	}
	
}
