package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rev.pojos.Checkings;
import com.rev.pojos.Users;
import com.rev.util.ConnectionFactory;

public class CheckingsDAO {

	public boolean doesAccountExist(Users user) {
		boolean exists = false;
		
		try ( Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CHECKINGS WHERE USERID = '" + user.getUserid() + "'");
			
			while (rs.next()) {
				exists = true;
				return exists;
			}
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return exists;
	}

	public boolean createAccount(Users user, double amount) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "INSERT INTO CHECKINGS (CHECKINGSID, USERID, TOTAL) VALUES(CHECKINGSID_SEQ.nextval, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  user.getUserid()); 
			ps.setDouble(2,  amount);
			int i = ps.executeUpdate();
			
			if (i == 1) {
				return true;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public Checkings total(Users user) {
		Checkings c = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT TOTAL FROM CHECKINGS WHERE USERID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserid());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				c = new Checkings();
				c.setTotal(rs.getDouble(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return c;
	}

	public boolean withdraw(Users user, double total) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE CHECKINGS SET TOTAL = ? WHERE USERID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, total);
			ps.setInt(2, user.getUserid());
			int i = ps.executeUpdate();
			
			if (i == 1) {
				return true;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

	public boolean deposit(Users user, double newTotal) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE CHECKINGS SET TOTAL = ? WHERE USERID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, newTotal);
			ps.setInt(2, user.getUserid());
			int i = ps.executeUpdate();
			
			if (i == 1 ) {
				return true;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return false;	
	}
}
