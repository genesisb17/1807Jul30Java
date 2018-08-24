package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;
import com.revature.model.UserInformation;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	
	private static UserDaoImpl instance;
	
	private UserDaoImpl() {}
	
	public static UserDaoImpl getInstance() {
		if(instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	public String getPasswordHash(User user) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			CallableStatement cs = conn.prepareCall("select GET_USER_HASH(?,?) from dual");
			
			cs.setString(++index, user.getUsername());
			cs.setString(++index, user.getPassword());
			
			ResultSet rs = cs.executeQuery();
			
			return rs.getString(1);
		}catch(SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}

	public UserInformation getUserInformation(String username) {
		int index = 0;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from example_user_information where username = ?");
			ps.setString(++index, username);
			ResultSet rs = ps.executeQuery();
			return new UserInformation(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4));
			
		}catch(SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;

	}

	public static void main(String[] args) {
		System.out.println(UserDaoImpl.getInstance().getPasswordHash((new User("tiffannieM","pwd"))));
	}
}
