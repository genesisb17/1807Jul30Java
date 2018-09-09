package com.reimb.service;

import java.util.List;

import com.reimb.dao.Dao;
import com.reimb.dao.UserDao;
import com.reimb.pojos.Users;

public class UserService {

	static Dao<Users, Integer> userdao = new UserDao();
	
	public Users findOne() {
		int id = 2;
		return userdao.findOne(id);
	}
	
	public Users addUser(Users u) {
		return userdao.save(u);
	}
	
	public List<Users> getAll() {
		return userdao.findAll();
	}
}
