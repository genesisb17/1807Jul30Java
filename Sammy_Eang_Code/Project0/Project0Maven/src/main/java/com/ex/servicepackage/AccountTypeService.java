package com.ex.servicepackage;

import java.util.List;

import com.ex.dao.AccountTypeDAO;
import com.ex.pojo.AccountType;

public class AccountTypeService {
	
	static AccountTypeDAO atService = new AccountTypeDAO();
	
	public static void main(String[] args) {
		List<AccountType> a = atService.findAll();
		for(AccountType b: a) {
			System.out.println(b);
		}
	}
	
}
