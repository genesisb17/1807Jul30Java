package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.pojos.User;
import com.ex.pojos.UserInformation;
import com.ex.util.ConnectionFactory;

public class UserInfoDao implements Dao<UserInformation, Integer> {

	public UserInformation findOne(String username) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM example_user_information "
					+ "WHERE username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new UserInformation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException sql) {
			System.err.println("SQL State: " +sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}

	@Override
	public UserInformation findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInformation save(UserInformation obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInformation update(UserInformation obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnique(UserInformation obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
		String query = "select * from ERS_USERS where ERS_USERNAME = ? or "
				+ "USER_EMAIL = ?";
		
		String[] keys = new String[1];
		keys[0] = "ERS_USERS_ID";	// column name where keys are
		
		PreparedStatement ps = conn.prepareStatement(query, keys);
		
		ps.setString(1, obj.getUsername());
		ps.setString(2, obj.getEmail());
		
		ResultSet info = ps.executeQuery();
		
		if(info.next()) {
			return false;
		} else {
			return true;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public List<UserInformation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
