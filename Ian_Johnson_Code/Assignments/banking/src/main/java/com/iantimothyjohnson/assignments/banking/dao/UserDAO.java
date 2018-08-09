package com.iantimothyjohnson.assignments.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.iantimothyjohnson.assignments.banking.pojos.Account;
import com.iantimothyjohnson.assignments.banking.pojos.User;

public class UserDAO extends SQLDAO<User> {
	private AccountDAO accountDao;

	public UserDAO(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<User> findAll() {
		final String query = "SELECT * FROM bank_user";

		try (Connection conn = ConnectionManager.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return collectFromResultSet(rs);
		} catch (SQLException se) {
			System.err.println("Got SQLException:");
			se.printStackTrace();
		}
		return null;
	}

	@Override
	public Optional<User> findById(int id) {
		final String query = "SELECT * FROM bank_user WHERE user_id = ?";

		try (Connection conn = ConnectionManager.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			List<User> users = collectFromResultSet(rs);
			// The ID is unique, so our list has at most one element.
			assert users.size() <= 1;
			return users.size() == 0 ? Optional.empty() : Optional.of(users.get(0));
		} catch (SQLException se) {
			System.err.println("Got SQLException:");
			se.printStackTrace();
		}
		return null;
	}

	public Optional<User> findByUsername(String username) {
		final String query = "SELECT * FROM bank_user WHERE username = ?";

		try (Connection conn = ConnectionManager.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			List<User> users = collectFromResultSet(rs);
			// The username is unique, so our list has at most one element.
			assert users.size() <= 1;
			return users.size() == 0 ? Optional.empty() : Optional.of(users.get(0));
		} catch (SQLException se) {
			System.err.println("Got SQLException:");
			se.printStackTrace();
		}
		return null;
	}

	@Override
	protected List<User> collectFromResultSet(ResultSet rs) throws SQLException {
		List<User> users = new ArrayList<User>();
		while (rs.next()) {
			int userId = rs.getInt("user_id");
			// First, let's get all the user's accounts.
			List<Account> accounts = accountDao.findAllForUser(userId);
			users.add(new User(userId, rs.getString("username"), rs.getBytes("password_salt"),
					rs.getBytes("hashed_password"), rs.getString("first_name"), rs.getString("last_name"), accounts));
		}
		return users;
	}
}
