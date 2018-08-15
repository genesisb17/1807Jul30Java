package com.ex.service;

import java.io.Serializable;
import java.util.List;

import com.ex.dao.Dao;
import com.ex.dao.TransactionDao;
import com.ex.pojos.Transactions;

public class TransactionService implements Dao{
	
	static Dao<Transactions, Integer> tDao = new TransactionDao();

	@Override
	public List findAll() {
		return null;
	}

	@Override
	public Object findOne(Serializable id) {
		return null;
	}

	@Override
	public Object save(Object obj) {
		return null;
	}

	@Override
	public Object update(Object obj) {
		return null;
	}

	@Override
	public void delete(Object obj) {
		
	}

}
