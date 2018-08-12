package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rev.pojos.Savings;
import com.rev.pojos.Users;
import com.rev.util.ConnectionFactory;

public class SavingsDAO {

	public static boolean doesAccountExist(Users user) {
		boolean exists = false;
		
		try ( Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SAVINGS WHERE USERID = '" + user.getUserid() + "'");
			
			while (rs.next()) {
				exists = true;
				return exists;
			}
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return exists;
	}

	public static boolean createSavingsAccount(Users user, double amount) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "INSERT INTO SAVINGS (SAVINGSID, USERID, TOTAL) VALUES(SAVINGSID_SEQ.nextval, ?, ?)";
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

	public static Savings total(Users user) {
		Savings s = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT TOTAL FROM SAVINGS WHERE USERID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserid());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				s = new Savings();
				s.setTotal(rs.getDouble(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return s;	
	}

	public static boolean withdraw(Users user, double total) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE SAVINGS SET TOTAL = ? WHERE USERID = ?";
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

	public static boolean deposit(Users user, double newTotal) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE SAVINGS SET TOTAL = ? WHERE USERID = ?";
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
