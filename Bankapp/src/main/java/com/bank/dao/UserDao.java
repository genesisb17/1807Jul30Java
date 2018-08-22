package com.bank.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.app.Driver;
import com.bank.pojo.User;
import com.bank.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class UserDao {
	
	
	public User addOne(User user) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO USERS (FIRSTNAME, LASTNAME, UNAME, UPASSWORD) VALUES (?,?,?,?)";
			String[] keys = {"U_ID"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1,user.getName());
			ps.setString(2, user.getLname());
			ps.setString(3,user.getUname());
			ps.setString(4,user.getPword());
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated>0) {
				ResultSet pk = ps.getGeneratedKeys();
				
				while(pk.next()) {
					System.out.println(pk.getInt(1));
					user.setId(pk.getInt(1));
					
				}
				conn.commit();
			}
			conn.commit();
		} catch (SQLException e) {
			System.out.println("that userrname was invalid please redo");
			Driver.createAccount();
			
		}
		return user;	
	}	

	public User findOne(String uname, String pwd) {
		User u = null;
		List<User> user = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT U_ID, FIRSTNAME, LASTNAME, UNAME, UPASSWORD FROM USERS WHERE UPPER(UNAME) = ? AND UPASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname.toUpperCase());
			ps.setString(2, pwd);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				u = new User();
				u.setId(info.getInt(1));
				u.setName(info.getString(2));
				u.setLname(info.getString(3));
				u.setUname(info.getString(4));
				u.setPword(info.getString(5));
				user.add(u);
			}

		} catch (SQLException e) {
			System.out.println("Those credentials were invalid, please try again");
			Driver.login();
		}

		return u;
	}
	public User findOneAfter(String uname) {
		User u = null;
		List<User> user = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT U_ID, FIRSTNAME, LASTNAME, UNAME, UPASSWORD FROM USERS WHERE UPPER(UNAME) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname.toUpperCase());
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				u = new User();
				u.setId(info.getInt(1));
				u.setName(info.getString(2));
				u.setLname(info.getString(3));
				u.setUname(info.getString(4));
				u.setPword(info.getString(5));
				user.add(u);
			}

		} catch (SQLException e) {
			Driver.login();
		} catch (NullPointerException e) {
			Driver.login();
		}

		return u;
	}
	
	public void deleteOne(String uname, String pwd) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "DELETE FROM USERS WHERE UPPER(UNAME) = ? AND UPASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname.toUpperCase());
			ps.setString(2, pwd);
			ps.executeUpdate();
			
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Those credentials were invalid, please try again");
			Driver.delete();
		} 

		
	}
	
}
