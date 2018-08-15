package com.revature.service;

import java.util.List;

import com.revature.dao.AllAccountsDao;
import com.revature.dao.Dao;
import com.revature.pojo.AllAccounts;

public class AllAccountService {

	static Dao<AllAccounts, Integer> aaDao = new AllAccountsDao();
	String string;
	
	
	public List<AllAccounts> getAll(int clientId){
		return aaDao.findAll();
		
	}
	
	public String getTime() {
		aaDao.findOne(null);
		return string;
	}
	
}
