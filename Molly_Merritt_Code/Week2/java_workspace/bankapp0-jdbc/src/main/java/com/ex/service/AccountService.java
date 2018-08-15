package com.ex.service;

import com.ex.dao.AccountDao;
import com.ex.dao.Dao;
import com.ex.pojos.Accounts;

public class AccountService {
	
	static Dao<Accounts, Integer> aDao = new AccountDao();
	
	public Accounts addAccount(Accounts a) {
		return aDao.save(a);
	}

}
