package com.ex.service;

import com.ex.dao.AccountDao;
import com.ex.dao.Dao;
import com.ex.pojos.Accounts;
import com.ex.pojos.Users;

public class AccountService {
	
	static AccountDao aDao = new AccountDao();
	
	public Accounts addAccount(Accounts a) {
		return aDao.save(a);
	}
	
	public Accounts updateAccount(int accountNumber, int accountType) {
		return aDao.update(accountNumber, accountType);
	}

}
