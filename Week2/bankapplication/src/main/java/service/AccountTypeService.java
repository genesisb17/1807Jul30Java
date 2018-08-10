package service;

import java.util.List;

import dao.AccountTypeDAO;
import dao.DAO;
import pojo.AccountType;

public class AccountTypeService {

	static DAO<AccountType, Integer> atDAO = new AccountTypeDAO();
	
	public List<AccountType> getAll() {
		return atDAO.getAll();
	}
	
	public AccountType save(AccountType b) {
		return atDAO.save(b);
	}
}
