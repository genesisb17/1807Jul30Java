package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rev.pojos.Users;
import com.rev.util.ConnectionFactory;

public class UsersDAO {

	public boolean isUsernameUnique(String username) {
		boolean notUnique = true;
		
		// Uses Statement
		// Should be a PreparedStatement but required by project
		try ( Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME = '" + username + "'");
			
			// Doesn't need to return anything from the query itself. Just needs to tell us whether a match was found or not
			// Sorry for the odd variable name...
			while(rs.next()) {
				notUnique = false;
				return notUnique;
			}
		}	catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		// Returning true means a match was found
		return notUnique;
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

	// Uses CallableStatement
	// TODO: FIX THIS
	public void nukeAccounts(String name, int userid) {		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call NUKE_ACCOUNTS_PROC(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, name);
			cs.setInt(2,  userid);
			cs.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
}