package com.reimbursement.service;

import java.util.List;

import com.reimbursement.dao.Dao;
import com.reimbursement.dao.UserDao;
import com.reimbursement.pojos.User;

public class UserService extends UserDao{

static Dao<User, Integer> dao = new UserDao();
	
	public User findById(int id) {
		return dao.findOne(id);
	}
	
	@Override
	public String getRoleName(User obj) {
		// TODO Auto-generated method stub
		return super.getRoleName(obj);
	}

	public User getByUsername(String n) {
		UserDao a=new UserDao();
		return a.getByUsername(n);
	}

	public List<User> getAll(){
		return dao.getAll();
	}
	
	public User addUser(User b){
		return dao.save(b);
	}
}