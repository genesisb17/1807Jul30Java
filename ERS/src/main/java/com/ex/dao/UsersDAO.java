package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ex.pojos.Users;
import com.ex.util.ConnectionFactory;

public class UsersDAO {

	public static Users validate(String username, String password) {
		Users u = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new Users();
				u.setUserid(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstname(rs.getString(4));
				u.setLastname(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setRoleid(rs.getInt(7));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return u;
	}
}
