package com.rev.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rev.pojos.Users;
import com.rev.util.ConnectionFactory;

public class UsersService {
	
	public static Users isUsernameUnique(String username) {
		Users u = null;
		
		// Uses PreparedStatement
		try ( Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM USERS WHERE USERNAME = ?";	
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  username);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				u = new Users();
				u.setId(info.getInt(1));
				u.setUsername(info.getString(2));
			}
		}	catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		if (u == null) {
			return null;
		}
		return u;
	}

	// Uses PreparedStatement
	public static boolean createBankingAccount(String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "INSERT INTO USERS (USERID, USERNAME, PASSWORD) VALUES(USERID_SEQ.nextval, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			int i = ps.executeUpdate();
			
			if (i == 1) {
				return true;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return false;
	}
}

