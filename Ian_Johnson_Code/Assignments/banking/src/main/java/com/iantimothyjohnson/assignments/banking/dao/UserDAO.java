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

import com.iantimothyjohnson.assignments.banking.pojos.User;
import com.iantimothyjohnson.assignments.banking.util.ConnectionFactory;

public class UserDAO {
	private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());

	/**
	 * Finds all users in the database.
	 * 
	 * @return A list of all users in the database (empty if there are no users).
	 */
	public List<User> findAll() {
		final String query = "SELECT * FROM bank_user";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return collectFromResultSet(rs);
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to query all users.", e);
		}
		return new ArrayList<>();
	}

	/**
	 * Finds the user with the given ID.
	 * 
	 * @param id The ID of the user to find.
	 * @return The user that was found, or null if no user has the specified ID.
	 */
	public User findById(int id) {
		final String query = "SELECT * FROM bank_user WHERE user_id = ?";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return parseResultSetRow(rs);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to query users by ID.", e);
		}
		return null;
	}

	/**
	 * Finds the user with the given username.
	 * 
	 * @param username The username of the user to find.
	 * @return The user that was found, or null if none was found.
	 */
	public User findByUsername(String username) {
		final String query = "SELECT * FROM bank_user WHERE username = ?";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			// Remember that usernames are not case-sensitive!
			ps.setString(1, username.toLowerCase());
			ResultSet rs = ps.executeQuery();
			// Usernames are unique, so we only need to expect one result.
			if (rs.next()) {
				return parseResultSetRow(rs);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to query users by username.", e);
		}
		return null;
	}

	/**
	 * Inserts a new user into the database.
	 * 
	 * @param user The user to insert. The ID of the user object will be updated to
	 *             reflect its new ID after being inserted into the database.
	 * @return Whether the user was actually inserted (this will be false if, e.g. a
	 *         user with the given username already exists or some other database
	 *         error occurred).
	 */
	public boolean insert(User user) {
		final String sql = "INSERT INTO bank_user " + "(username, password_salt, password_hash, first_name, last_name) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// We want to retrive the auto-generated user_id key.
			String[] keys = { "user_id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, user.getUsername().toLowerCase());
			ps.setBytes(2, user.getPasswordSalt());
			ps.setBytes(3, user.getPasswordHash());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());

			int inserted = ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (inserted > 0 && generatedKeys.next()) {
				// We update the user's ID with the ID it now has in the
				// database.
				user.setId(generatedKeys.getInt(1));
				return true;
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to insert new user into database.", e);
		}
		return false;
	}

	/**
	 * Updates the user data in the database corresponding to the given (existing)
	 * user.
	 * 
	 * @param user The user to save to the database.
	 * @return Whether the user was actually updated (that is, true if the user
	 *         existed, false if there was no such user, as determined by the user's
	 *         ID).
	 */
	public boolean update(User user) {
		final String sql = "UPDATE bank_user "
				+ "SET username = ?, password_salt = ?, password_hash = ?, first_name = ?, last_name = ? "
				+ "WHERE user_id = ?";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername().toLowerCase());
			ps.setBytes(2, user.getPasswordSalt());
			ps.setBytes(3, user.getPasswordHash());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setInt(6, user.getId());

			// We check how many rows were affected to see if the user actually
			// existed.
			int affected = ps.executeUpdate();
			return affected > 0;
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to update user in database.", e);
		}
		return false;
	}

	private User parseResultSetRow(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("user_id"));
		user.setUsername(rs.getString("username"));
		user.setPasswordSalt(rs.getBytes("password_salt"));
		user.setPasswordHash(rs.getBytes("password_hash"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		return user;
	}

	private List<User> collectFromResultSet(ResultSet rs) throws SQLException {
		List<User> users = new ArrayList<User>();
		while (rs.next()) {
			users.add(parseResultSetRow(rs));
		}
		return users;
	}
}
