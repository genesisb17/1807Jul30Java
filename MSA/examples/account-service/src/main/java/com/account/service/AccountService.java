package com.account.service;

import java.util.List;

import com.account.beans.Account;

public interface AccountService {

	List<Account> findAll();
	Account findById(int id);
	List<Account> findByCustomer(int id);
	Account add(Account acc);
	
}
