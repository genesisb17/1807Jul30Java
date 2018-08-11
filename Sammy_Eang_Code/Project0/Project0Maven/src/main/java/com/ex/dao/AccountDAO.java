package com.ex.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.connectionfactory.ConnectionFactory;
import com.ex.pojo.Account;

public class AccountDAO implements DAO<Account, Integer> {

	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "select balance from account";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Account temp = new Account();
				temp.setBalance(rs.getDouble("balance"));
				accounts.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account findOne(Integer id) {
		
		return null;
	}

	@Override
	public Account save(Account obj) {
		return null;
		
		
	}

	@Override
	public Account update(Account obj) {
		
		return null;
	}

	@Override
	public void delete(Account obj) {
		
		
	}

}
