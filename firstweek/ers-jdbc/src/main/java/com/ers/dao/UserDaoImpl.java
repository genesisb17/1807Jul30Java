package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.pojo.User;
import com.ers.pojo.UserInfo;
import com.ers.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	private static UserDaoImpl instance;
	private UserDaoImpl() {
		
	}
	
	public static UserDaoImpl getInstance() {
		if (instance == null) 
			instance = new UserDaoImpl();
			return instance;
		
	}
	@Override
	public String getPasswordHash(User user) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement cs = conn.prepareStatement("SELECT GET_USER_HASH(?,?) as hash FROM DUAL");
			cs.setString(++index, user.getUsername());
			cs.setString(++index, user.getPassword());
			ResultSet rs = cs.executeQuery();
			if(rs.next())
				return rs.getString("hash");
			
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		
		return null;
	}

	@Override
	public UserInfo getUserInfo(String username) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_information WHERE USERNAME = ?");
			ps.setString(++index, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			return new UserInfo(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4));
		
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}
		
		return null;
	

	}
	
	public User getUser(String username) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ?");
			ps.setString(++index,  username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return new User(rs.getString(1), rs.getString(2));
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}
		
		return null;
		
	}
	
	
}
