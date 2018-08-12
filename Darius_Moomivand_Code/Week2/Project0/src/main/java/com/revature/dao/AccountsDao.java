package com.revature.dao;

import com.revature.pojo.Accounts;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "INSERT INTO accounts(balance, acc_type_id) values(?,?)";
			String[] keys = new String[1];
			keys[0] = "account_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setLong(1, obj.getAccountTypeId());
			ps.setDouble(2, obj.getBalance());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setAccId(pk.getInt(1));
				}
				
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
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
