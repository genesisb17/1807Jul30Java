package com.ex.service;

import com.ex.dao.CreateDao;
import com.ex.dao.DAO;
import com.ex.pojos.Login;

public class CreateService {
	/*
	 * SERVICE LAYER IS BUSINESS LOGIC
	 * maybe need two dao methods at once
	 * or dao methods from different classes
	 * or some sort of manipulation of data either
	 * pre or post dao method call should go here
	 */
	
	static DAO<Login, Integer> cDao = new CreateDao();
	
	public Login create_account(String username, String password, String firstname, String lastname) {
		
		return cDao.insert(username, password, firstname, lastname);
		
	}
	
}