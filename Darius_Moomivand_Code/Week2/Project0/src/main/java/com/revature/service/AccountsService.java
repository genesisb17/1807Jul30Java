package com.revature.service;

import java.util.List;

import com.revature.dao.AccountsDao;
import com.revature.dao.Dao;
import com.revature.pojo.Accounts;

public class AccountsService {
	
	static Dao<Accounts, Integer> aDao = new AccountsDao();

	
	
	
	public List<Accounts> getAll(){
		return aDao.findAll();
	}
	
	
	
	
	
	
}
