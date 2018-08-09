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

public class AccountDAO extends SQLDAO<Account> {
	@Override
	public List<Account> findAll() {
		final String query = "SELECT * FROM account";

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

	public List<Account> findAllForUser(int userId) {
		final String query = "SELECT * FROM account WHERE account_id IN"
				+ "(SELECT account_id FROM user_account WHERE user_id = ?)";
		
		try (Connection conn = ConnectionManager.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			return collectFromResultSet(rs);
		} catch (SQLException se) {
			System.err.println("Got SQLException:");
			se.printStackTrace();
		}
		return null;
	}

	@Override
	public Optional<Account> findById(int id) {
		final String query = "SELECT * FROM account WHERE account_id = ?";

		try (Connection conn = ConnectionManager.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			List<Account> accounts = collectFromResultSet(rs);
			// The ID is unique, so our list has at most one element.
			assert accounts.size() <= 1;
			return accounts.size() == 0 ? Optional.empty() : Optional.of(accounts.get(0));
		} catch (SQLException se) {
			System.err.println("Got SQLException:");
			se.printStackTrace();
		}
		return null;
	}

	@Override
	protected List<Account> collectFromResultSet(ResultSet rs) throws SQLException {
		List<Account> accounts = new ArrayList<>();
		while (rs.next()) {
			accounts.add(new Account(rs.getInt("account_id"), rs.getString("name"), rs.getBigDecimal("balance")));
		}
		return accounts;
	}
}
