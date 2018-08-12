package service;

import java.util.List;

import dao.AccountDAO;
import dao.DAO;
import pojo.Account;

public class AccountService {
	
	static DAO<Account, Integer> aDAO = new AccountDAO();
	
	public List<Account> getAll() {
		return aDAO.getAll();
	}
	
	public Account save(Account b) {
		return aDAO.save(b);
	}
	
	public Account update(Account b) {
		return aDAO.update(b);
	}
	
}
