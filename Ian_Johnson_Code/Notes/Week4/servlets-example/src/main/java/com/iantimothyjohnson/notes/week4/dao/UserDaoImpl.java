package com.iantimothyjohnson.notes.week4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iantimothyjohnson.notes.week4.pojos.User;
import com.iantimothyjohnson.notes.week4.pojos.UserInformation;
import com.iantimothyjohnson.notes.week4.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	@Override
	public User getUser(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM example_users WHERE username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getPasswordHash(User user) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT get_user_hash(?, ?) AS hash FROM DUAL");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("hash");
			}
		} catch (SQLException e) {
			System.err.println("SQL state: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		return null;
	}

	@Override
	public UserInformation getUserInformation(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM example_user_information WHERE username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new UserInformation(rs.getString("username"), rs.getString("firstname"),
						rs.getString("lastname"), rs.getString("email"));
			}
		} catch (SQLException e) {
			System.err.println("SQL state: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		return null;
	}
}
