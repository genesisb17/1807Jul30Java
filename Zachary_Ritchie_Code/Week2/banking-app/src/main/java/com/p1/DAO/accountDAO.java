package com.p1.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.p1.pojo.account;
import com.p1.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class accountDAO implements DAO<account, Integer>
{

	@Override
	public List<account> getAll() 
	{
		List<account> acc = new ArrayList<account>();
		
		String sql = "{call get_all_accounts(?)}";
		
		try(Connection c = ConnectionFactory.getInstance().getConnection())
		{
			CallableStatement cs = c.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet)cs.getObject(1);
			while(rs.next())
			{
				account temp = new account();
				temp.setAccount_Name(rs.getString("account_name"));
				temp.setAccount_type(rs.getString("account_type"));
				temp.setBalance(rs.getDouble("balance"));
				temp.setAccount_Id(rs.getInt("account_id"));
				acc.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return acc;		
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
			
			String sql = "insert into accounts(account_name, account_type, balance, user_id) values(?, ?, ?, ?)";
			
			String[] keys = {"account_id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, obj.getAccount_Name());
			ps.setString(2, obj.getAccount_type());
			ps.setDouble(3, obj.getBalance());
			ps.setInt(4, obj.getCustomer_id());
			
			int numsRowsAffected = ps.executeUpdate();
			
			if(numsRowsAffected > 0)
			{
				ResultSet pk = ps.getGeneratedKeys();
				
				while(pk.next()) 
				{
					obj.setAccount_Id(pk.getInt(1));
				}
			}
			
			conn.commit();			
			
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
