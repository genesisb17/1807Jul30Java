package com.ex.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.connectionfactory.ConnectionFactory;
import com.ex.pojo.AccountType;

public class AccountTypeDAO implements DAO<AccountType, Integer>{

	@Override
	public List<AccountType> findAll() {
		List<AccountType> accounttypes = new ArrayList<AccountType>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "select account_type_id, account_type from account_type";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				AccountType temp = new AccountType();
				temp.setAccount_type(rs.getString("account_type"));
				temp.setAccount_type_id(rs.getInt("account_type_id"));
				accounttypes.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounttypes;
	}

	@Override
	public AccountType findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountType save(AccountType obj) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountType update(AccountType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(AccountType obj) {
		// TODO Auto-generated method stub
		
	}
	

}
