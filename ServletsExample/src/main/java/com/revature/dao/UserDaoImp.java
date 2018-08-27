package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;
import com.revature.model.UserInformation;
import com.revature.util.ConnectionFactory;

public class UserDaoImp implements UserDao {

	private static UserDaoImp instance;
	
	private UserDaoImp() {}
	
	public static UserDaoImp getInstance() {
		if (instance == null)
			instance = new UserDaoImp();
		return instance;
	}
	
	@Override
	public String getPasswordHash(User user) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareCall(" SELECT get_user_hash(?,?) AS HASH FROM dual");
			ps.setString(++index, user.getUsername());
			ps.setString(++index, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString("HASH");
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.print("Error Code: " + sql.getErrorCode());	
		}
		return null;
	}
	
	@Override
	public UserInformation getUserInformation(String username) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM example_user_information WHERE username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return new UserInformation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.print("Error Code: " + sql.getErrorCode());	
		}
		return null;
	}

	@Override
	public User getUser(String username) {
		int index = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM EXAMPLE_USERS WHERE USERNAME = ?");
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
