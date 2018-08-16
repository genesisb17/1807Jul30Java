package com.ex.service;

import com.ex.dao.BankTypeDao;
import com.ex.dao.DAO;
import com.ex.pojos.BankType;

public class TransactionService{

	static DAO<BankType, Integer> btDao = new BankTypeDao();
	
	public BankType update(BankType d) {
		
		btDao.update(d);
		return d;
	}
	
	public BankType findOne(BankType s) {
		btDao.findOne(s);
		return s;
	}
	
}
