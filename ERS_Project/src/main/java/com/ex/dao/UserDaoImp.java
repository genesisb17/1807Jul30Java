package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ex.dao.UserDao;
import com.ex.dao.UserDaoImp;
import com.ex.pojos.User;
import com.ex.pojos.UserInformation;
import com.ex.util.ConnectionFactory;

public class UserDaoImp implements UserDao {

	private static UserDaoImp instance;
	
	// No argument constructor
	private UserDaoImp() {}
	
	// Checks if instance exists, creates one if not there
	public static UserDaoImp getInstance() {
		if (instance == null)
			instance = new UserDaoImp();
		return instance;
	}
	
	@Override
	public String getPasswordHash(User user) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareCall("SELECT get_user_hash(?,?) AS HASH FROM dual");
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
			PreparedStatement stmt = conn.prepareStatement("SELECT username, "
					+ "firstname, lastname, email, user_roles.U_ROLE "
					+ "FROM user_information inner join user_roles "
					+ "on user_information.ur_id=user_roles.ur_id "
					+ "WHERE USERNAME = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return new UserInformation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ?");
			ps.setString(++index,  username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				System.out.println(rs);
				return new User(rs.getString(1), rs.getString(2));
			
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}

		return null;
	}
}

