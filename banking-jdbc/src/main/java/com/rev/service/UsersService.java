package com.rev.service;

import com.rev.dao.UsersDAO;
import com.rev.pojos.Users;

public class UsersService {
	
	private static UsersDAO UsersDAO = new UsersDAO();
	
	public static Users isUsernameUnique(String username) {
		return UsersDAO.isUsernameUnique(username);
	}
	
	public static boolean createBankingAccount(String username, String password) {
		return UsersDAO.createBankingAccount(username, password);	
	}

	public static Users logIn(int userid, String username, String password) {
		return UsersDAO.logIn(userid, username, password);
	}
}