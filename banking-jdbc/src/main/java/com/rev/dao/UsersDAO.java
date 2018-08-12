package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rev.pojos.Users;
import com.rev.util.ConnectionFactory;

public class UsersDAO {

	public Users isUsernameUnique(String username) {
		Users u = null;
		
		// Uses Statement
		try ( Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME = '" + username + "'");
			
			while(rs.next()) {
				u = new Users();
				u.setUsername(rs.getString(1));
			}
		}	catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		// Should return null if unique
		if (u == null) {
			return null;
		}
		
		// Only returns anything except null if username is not unique
		return u;
	}

	// Uses PreparedStatement
	public boolean createBankingAccount(String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "INSERT INTO USERS (USERID, USERNAME, PASSWORD) VALUES(USERID_SEQ.nextval, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			int i = ps.executeUpdate();
			
			// To show that the SQL statement executed correctly
			// 1 means that "one row was inserted"
			if (i == 1) {
				return true;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		// Returning false means something wrong happened
		// "no rows were inserted"
		return false;
	}
	
	//Uses PreparedStatement
	public Users logIn(int userid, String username, String password) {
		Users u = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2,  password);
			ResultSet rs = ps.executeQuery();
			
			// Creates the object for the creds supplied
			// If no creds were found, then it'll pass this
			while(rs.next()) {
				u = new Users();
				u.setUserid(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		// Will return either null or an object with creds
		return u;
	}
}