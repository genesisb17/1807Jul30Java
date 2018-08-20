package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utils.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class AccessDAO {
	
	public long login(String username, String password) {
		long success = -1L;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT login_attempt(?,?) FROM DUAL";
			
			PreparedStatement cs = conn.prepareCall(query);
			cs.setString(1, username);
			cs.setString(2, password);
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				success = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public long createAccount(String username, String password) {
		long success = -1L;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "{call create_user_account(?,?,?)}";
			
			CallableStatement cs = conn.prepareCall(query);
			cs.setString(1,username);
			cs.setString(2, password);
			cs.registerOutParameter(3, OracleTypes.NUMBER);
			
			int x = cs.executeUpdate();
			if(x>0) {
			success = cs.getLong(3);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

}
