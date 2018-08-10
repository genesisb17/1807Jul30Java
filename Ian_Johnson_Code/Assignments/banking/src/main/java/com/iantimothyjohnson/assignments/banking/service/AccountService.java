package com.iantimothyjohnson.assignments.banking.service;

import java.util.List;
import java.util.stream.Collectors;

import com.iantimothyjohnson.assignments.banking.dao.AccountDAO;
import com.iantimothyjohnson.assignments.banking.dao.UserAccountDAO;
import com.iantimothyjohnson.assignments.banking.pojos.Account;
import com.iantimothyjohnson.assignments.banking.pojos.User;

/**
 * A singleton service for accessing account information, abstracting over the
 * DAO.
 * 
 * @author Ian Johnson
 */
public final class AccountService {
	private static AccountService instance;

	private UserAccountDAO userAccountDao;
	private AccountDAO accountDao;

	private AccountService() {
		userAccountDao = new UserAccountDAO();
		accountDao = new AccountDAO();
	}

	public static AccountService getInstance() {
		if (instance == null) {
			instance = new AccountService();
		}
		return instance;
	}

	/**
	 * Finds all accounts belonging to the given user.
	 * 
	 * @param user The user whose accounts to find.
	 * @return A list of all the user's accounts, as Account objects.
	 */
	public List<Account> findAllForUser(User user) {
		return userAccountDao.findAccountsForUser(user.getId()).stream()
				.map(accountId -> accountDao.findById(accountId)).collect(Collectors.toList());
	}
}
