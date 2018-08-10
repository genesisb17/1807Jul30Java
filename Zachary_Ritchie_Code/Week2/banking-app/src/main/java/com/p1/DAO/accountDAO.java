package com.p1.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.p1.pojo.account;
import com.p1.util.ConnectionFactory;

public class accountDAO implements DAO<account, Integer>
{

	@Override
	public List<account> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public account findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public account save(account obj) 
	{		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			
			String sql = "insert into accounts(account_name, account_type, balance) values(?, ?, ?)";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public account update(account obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(account obj) {
		// TODO Auto-generated method stub
		
	}

}
