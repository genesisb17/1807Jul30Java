package com.p1.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.p1.pojo.customer;
import com.p1.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class customerDAO implements DAO<customer, Integer>
{

	@Override
	public List<customer> getAll() 
	{
		List<customer> customer = new ArrayList<customer>();
		
		try(Connection c = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "{call get_all_customers(?)}";
			

			CallableStatement cs = c.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet)cs.getObject(1);
			while(rs.next())
			{
				customer temp = new customer();
				temp.setFirstName(rs.getString("first_name"));
				temp.setLastName(rs.getString("last_name"));
				temp.setUser_Username(rs.getString("user_username"));
				temp.setUser_Password(rs.getString("user_password"));
				temp.setUserId(rs.getInt("user_id"));
				System.out.println(temp);
				customer.add(temp);
				
			}

			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return customer;
	}

	@Override
	public customer findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public customer findOne(String name) 
	{
		customer cus = new customer();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from customer where user_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet info =  ps.executeQuery();
			info.next();
			cus.setUserId(info.getInt(1));
			cus.setFirstName(info.getString(2));
			cus.setLastName(info.getString(3));
			cus.setUser_Username(info.getString(4));
			cus.setUser_Password(info.getString(5));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cus;
	}

	@Override
	public customer save(customer obj) 
	{
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			
			String sql = "insert into customer(first_name, last_name, user_username, user_password) values(?, ?, ?, ?)";
			
			String[] keys = {"user_id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getUser_Username());
			ps.setString(4, obj.getUser_Password());
			
			int numsRowsAffected = ps.executeUpdate();
			
			if(numsRowsAffected > 0)
			{
				ResultSet pk = ps.getGeneratedKeys();
				
				while(pk.next()) 
				{
					obj.setUserId(pk.getInt(1));
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
	public customer update(customer obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(customer obj) {
		// TODO Auto-generated method stub
		
	}

}
