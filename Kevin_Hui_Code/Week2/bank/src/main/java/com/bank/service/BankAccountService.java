package com.bank.service;

import java.util.List;

import com.bank.dao.BankAccountDao;
import com.bank.pojos.BankAccount;

public class BankAccountService extends BankAccountDao {

	static BankAccountDao bankAccountDao = new BankAccountDao();
	
	public List<BankAccount> listAccounts(Integer id) {
		return bankAccountDao.findAssoc(id);
	}
	
	public BankAccount getAccount(Integer id) {
		return bankAccountDao.findOne(id);
	}
	
	public BankAccount addAccount(BankAccount ba) {
		return bankAccountDao.save(ba);
	}
	
	public BankAccount updateAccount(BankAccount ba) {
		return bankAccountDao.update(ba);
	}
}