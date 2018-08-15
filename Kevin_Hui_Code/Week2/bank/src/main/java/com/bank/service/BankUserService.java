package com.bank.service;

import java.util.List;

import com.bank.dao.Dao;
import com.bank.dao.BankUserDao;
import com.bank.pojos.BankUser;

public class BankUserService extends BankUserDao {
	
	static BankUserDao bankUserDao = new BankUserDao();
	
	public List<BankUser> getUsers() {
		return bankUserDao.findAll();
	}
	
	public BankUser getUser(Integer id) {
		return bankUserDao.findOne(id);
	}
	
	public BankUser addUser(BankUser u) {
		return bankUserDao.save(u);
	}
	
}