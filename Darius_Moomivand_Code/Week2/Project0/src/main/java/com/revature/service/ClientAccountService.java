package com.revature.service;

import java.util.List;

import com.revature.dao.Dao;
import com.revature.pojo.ClientAccount;
import com.revature.dao.ClientAccountDoa;

public class ClientAccountService {

	
	static Dao<ClientAccount, Integer> caDao = new ClientAccountDoa();

	
	public void saveNew(ClientAccount obj) {
		caDao.save(obj);
	}
	
	public List<ClientAccount> getAll(){
		return caDao.findAll();
	}
	
	
	public void getAccounts(int id) {
		caDao.findOne(id);
	}
}
