package com.iantimothyjohnson.assignments.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.iantimothyjohnson.assignments.banking.pojos.Account;
import com.iantimothyjohnson.assignments.banking.util.ConnectionFactory;

public class AccountDAO implements DAO<Account> {
	private static final Logger LOGGER = Logger.getLogger(AccountDAO.class.getName());

	@Override
	public List<Account> findAll() {
		final String query = "SELECT * FROM account";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return collectFromResultSet(rs);
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to query all accounts.", e);
		}
		return null;
	}

	@Override
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
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to find account by ID.", e);
		}
		return null;
	}
	
	@Override
	public boolean delete(int id) {
		final String sql = "DELETE FROM account WHERE account_id = ?";
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int affected = ps.executeUpdate();
			return affected > 0;
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to delete account from database.", e);
		}
		return false;
	}

	@Override
	public boolean insert(Account account) {
		final String sql = "INSERT INTO account (type, name, balance) VALUES (?, ?, ?)";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// We want to retrive the auto-generated account_id key.
			String[] keys = { "account_id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, account.getType());
			ps.setString(2, account.getName());
			ps.setBigDecimal(3, account.getBalance());

			int inserted = ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (inserted > 0 && generatedKeys.next()) {
				// We update the account's ID with the ID it now has in the
				// database.
				account.setId(generatedKeys.getInt(1));
				return true;
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to insert new account into database.", e);
		}
		return false;
	}

	@Override
	public boolean update(Account account) {
		final String sql = "UPDATE account SET type = ?, name = ?, balance = ? WHERE account_id = ?";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account.getType());
			ps.setString(2, account.getName());
			ps.setBigDecimal(3, account.getBalance());
			ps.setInt(4, account.getId());

			// We check how many rows were affected to see if the user actually
			// existed.
			int affected = ps.executeUpdate();
			return affected > 0;
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to update account in database.", e);
		}
		return false;
	}

	private Account parseResultSetRow(ResultSet rs) throws SQLException {
		return new Account(rs.getInt("account_id"), rs.getString("type"), rs.getString("name"), rs.getBigDecimal("balance"));
	}

	private List<Account> collectFromResultSet(ResultSet rs) throws SQLException {
		List<Account> accounts = new ArrayList<>();
		while (rs.next()) {
			accounts.add(parseResultSetRow(rs));
		}
		return accounts;
	}
}
