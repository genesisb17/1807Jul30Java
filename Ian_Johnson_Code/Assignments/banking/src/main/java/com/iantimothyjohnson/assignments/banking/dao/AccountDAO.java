package com.iantimothyjohnson.assignments.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iantimothyjohnson.assignments.banking.pojos.Account;
import com.iantimothyjohnson.assignments.banking.util.ConnectionFactory;

public class AccountDAO {
	public List<Account> findAll() {
		final String query = "SELECT * FROM account";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return collectFromResultSet(rs);
		} catch (SQLException se) {
			System.err.println("Got SQLException:");
			se.printStackTrace();
		}
		return null;
	}

	public Account findById(int id) {
		final String query = "SELECT * FROM account WHERE account_id = ?";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			List<Account> accounts = collectFromResultSet(rs);
			// The ID is unique, so our list has at most one element.
			assert accounts.size() <= 1;
			return accounts.size() == 0 ? null : accounts.get(0);
		} catch (SQLException se) {
			System.err.println("Got SQLException:");
			se.printStackTrace();
		}
		return null;
	}

	/**
	 * Inserts a new account into the database.
	 * 
	 * @param account The account to insert. The ID of the account object will be
	 *                updated to reflect its new ID after being inserted into the
	 *                database.
	 * @return Whether the account was actually inserted.
	 */
	public boolean insert(Account account) {
		final String sql = "INSERT INTO account (name, balance) VALUES (?, ?)";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// We want to retrive the auto-generated account_id key.
			String[] keys = { "account_id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, account.getName());
			ps.setBigDecimal(2, account.getBalance());

			int inserted = ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (inserted > 0 && generatedKeys.next()) {
				// We update the account's ID with the ID it now has in the
				// database.
				account.setId(generatedKeys.getInt(1));
				return true;
			}
		} catch (SQLException se) {
			System.err.println("Got SQLException:");
			se.printStackTrace();
		}
		return false;
	}

	/**
	 * Updates the account data in the database corresponding to the given
	 * (existing) account.
	 * 
	 * @param account The account to save to the database.
	 * @return Whether the account was actually updated (that is, true if the
	 *         account existed, false if there was no such account, as determined by
	 *         the account's ID).
	 */
	public boolean update(Account account) {
		final String sql = "UPDATE account SET name = ?, balance = ? WHERE account_id = ?";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account.getName());
			ps.setBigDecimal(2, account.getBalance());
			ps.setInt(3, account.getId());

			// We check how many rows were affected to see if the user actually
			// existed.
			int affected = ps.executeUpdate();
			return affected > 0;
		} catch (SQLException se) {
			System.err.println("Got SQLException:");
			se.printStackTrace();
		}
		return false;
	}

	private Account parseResultSetRow(ResultSet rs) throws SQLException {
		return new Account(rs.getInt("account_id"), rs.getString("name"), rs.getBigDecimal("balance"));
	}

	private List<Account> collectFromResultSet(ResultSet rs) throws SQLException {
		List<Account> accounts = new ArrayList<>();
		while (rs.next()) {
			accounts.add(parseResultSetRow(rs));
		}
		return accounts;
	}
}
