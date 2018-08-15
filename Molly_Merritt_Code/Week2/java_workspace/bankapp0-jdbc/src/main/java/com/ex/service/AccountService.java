package com.ex.service;

import com.ex.dao.AccountDao;
import com.ex.dao.Dao;
import com.ex.pojos.Accounts;
import com.ex.pojos.Users;

public class AccountService {
	
	static Dao<Accounts, Integer> aDao = new AccountDao();
	
	public Accounts addAccount(Accounts a) {
		return aDao.save(a);
	}

}
