package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.pojos.ers_users;
import com.ex.util.ConnectionFactory;

public class ers_usersDAO implements DAO<ers_users, Integer>
{

	public List<ers_users> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ers_users findOne(String name) 
	{
		//System.out.println("IN DAO");
		ers_users user = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			
			String sql = "select * from ers_users where ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet info =  ps.executeQuery();
		
			if(info.next())
			{
				user = new ers_users();
				user.setErs_user_id(info.getInt("ers_users_id"));
				user.setErs_username(info.getString("ers_username"));
				user.setErs_password(info.getString("ers_password"));
				user.setErs_first_name(info.getString("user_first_name"));
				user.setErs_last_name(info.getString("user_last_name"));
				user.setUser_email(info.getString("user_email"));
				user.setUser_role_id(info.getInt("user_role_id"));
			}
			else
			{
				//System.out.println("null");
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	public ers_users find(String name) 
	{
		//System.out.println("IN DAO");
		ers_users user = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			
			String sql = "select * from ers_users where ers_users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet info =  ps.executeQuery();
		
			if(info.next())
			{
				user = new ers_users();
				user.setErs_user_id(info.getInt("ers_users_id"));
				user.setErs_username(info.getString("ers_username"));
				user.setErs_password(info.getString("ers_password"));
				user.setErs_first_name(info.getString("user_first_name"));
				user.setErs_last_name(info.getString("user_last_name"));
				user.setUser_email(info.getString("user_email"));
				user.setUser_role_id(info.getInt("user_role_id"));
			}
			else
			{
				//System.out.println("null");
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	public ers_users findOneEmail(String name) 
	{
		//System.out.println("IN DAO");
		ers_users user = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			
			String sql = "select * from ers_users where user_email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet info =  ps.executeQuery();
		
			
			if(info.next())
			{
				user = new ers_users();
				user.setErs_user_id(info.getInt("ers_users_id"));
				user.setErs_username(info.getString("ers_username"));
				user.setErs_password(info.getString("ers_password"));
				user.setErs_first_name(info.getString("user_first_name"));
				user.setErs_last_name(info.getString("user_last_name"));
				user.setUser_email(info.getString("user_email"));
				user.setUser_role_id(info.getInt("user_role_id"));
			}
			else
			{
				//System.out.println("null");
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public ers_users save(ers_users obj)
	{
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			
			String sql = "insert into ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values(?, ?, ?, ?, ?, ?)";
			
			String[] keys = {"ers_users_id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, obj.getErs_username());
			ps.setString(2, obj.getErs_password());
			ps.setString(3, obj.getErs_first_name());
			ps.setString(4, obj.getErs_last_name());
			ps.setString(5, obj.getUser_email());
			ps.setInt(6, obj.getUser_role_id());
			
			ps.executeUpdate();
			
			/*int numsRowsAffected = ps.executeUpdate();
			
			if(numsRowsAffected > 0)
			{
				ResultSet pk = ps.getGeneratedKeys();
				
				while(pk.next()) 
				{
					obj.setErs_user_id(pk.getInt(1));
				}
			}*/
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	public ers_users update(ers_users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUnique(ers_users obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public ers_users findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
