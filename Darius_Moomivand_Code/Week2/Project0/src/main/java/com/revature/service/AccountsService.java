package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.AccountsDao;
import com.revature.dao.Dao;
import com.revature.pojo.Accounts;

public class AccountsService {
	
	static Dao<Accounts, Integer> aDao = new AccountsDao();

	
	public int saveNew(Accounts obj) {
		Accounts account = aDao.save(obj);
		int newId = account.getAccId();
		return newId;
	}
	
	public List<Accounts> getAll(){
		return aDao.findAll();
	}
	
	
	
	
	
	
}
