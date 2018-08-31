package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.ErsUser;
import com.revature.util.ConnectionFactory;

public class ErsUsersDao implements DAO<ErsUser, Integer> {

	@Override
	public List<ErsUser> findAll() {
		List<ErsUser> users = new ArrayList<ErsUser>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "SELECT * FROM ERS_USERS ORDER BY ERS_USER_ID";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				users.add(new ErsUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));

			}
		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return users;
	}

	@Override
	public ErsUser findOne(Integer id) {
		ErsUser user = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "SELECT * FROM ERS_USERS WHERE ERS_USER_ID = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				user = new ErsUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return user;
	}

	public ErsUser findUser(String username) {
		ErsUser user = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				user = new ErsUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return user;
	}

	@Override
	public ErsUser insert(ErsUser obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstname());
			ps.setString(4, obj.getLastname());
			ps.setString(5, obj.getEmail());
			ps.setInt(6, obj.getRoleId());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return obj;
	}

	@Override
	public ErsUser update(ErsUser obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ErsUser obj) {
		// TODO Auto-generated method stub

	}

}
