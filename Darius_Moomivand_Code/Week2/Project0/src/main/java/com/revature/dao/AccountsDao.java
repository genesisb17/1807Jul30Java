package com.revature.dao;

import com.revature.pojo.Accounts;

import java.util.ArrayList;
import java.util.List;

public class AccountsDao implements Dao<Accounts, Integer>{

	@Override
	public List<Accounts> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accounts findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accounts save(Accounts obj) {
/*		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "insert into accounts(accountType, type) values(?,?)";
			String[] keys = {""
*/		
		return obj;
	}

	@Override
	public Accounts update(Accounts obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Accounts obj) {
		// TODO Auto-generated method stub
		
	
	}
	
	
}
