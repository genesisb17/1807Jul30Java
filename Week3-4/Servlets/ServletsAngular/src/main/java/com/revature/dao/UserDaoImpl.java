package com.revature.dao;

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
		if (instance == null)
			instance = new UserDaoImpl();
		return instance;
	}
	
	@Override
	public String getPasswordHash(User user) {

		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement cs = conn.prepareStatement("select GET_USER_HASH(?,?) as HASH from dual");
			cs.setString(++index, user.getUsername());
			cs.setString(++index, user.getPassword());
			ResultSet rs = cs.executeQuery();
			if (rs.next()) {
				return rs.getString("HASH");
			}
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}

	@Override
	public UserInformation getUserInformation(String username) {
		// TODO Auto-generated method stub
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT username, firstname, lastname, email FROM example_user_information WHERE username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return new UserInformation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}
	
	public static void main(String[] args) {
		//.out.println(UserDaoImpl.getInstance().getPasswordHash("williamG"));
	}

	@Override
	public User getUser(String username) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM example_users WHERE username = ?");
			stmt.setString(++index,  username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return new User(rs.getString(1), rs.getString(2));
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}

}
