package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.pojo.User;
import com.ers.util.ConnectionFactory;

public class UserDao {
	
	public User addOne(User user) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO USERS (USERNAME, UPASSWORD, FIRSTNAME, LASTNAME, EMAIL, UR_ID) VALUES (?,?,?,?,?,1)";
			String[] keys = {"U_ID"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, user.getUname());
			ps.setString(1, user.getPwd());
			ps.setString(1, user.getFirstname());
			ps.setString(1, user.getLastname());
			ps.setString(1, user.getEmail());
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated >0) {
				ResultSet pk = ps.getGeneratedKeys();
				
				while(pk.next()) {
					user.setUid(pk.getInt(1));
				}
				conn.commit();
			}
			conn.commit();
		} catch (SQLException e) {
			// try and toss this up to the service layer.
		}
		return user;
	}
	
	
	//user login method checks username and password in the database
	public User findOne(String uname, String pwd) {
		User u = null;
		List<User> user = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql  = "SELECT * FROM USERS WHERE UPPER(USERNAME) = ? AND UPASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname.toUpperCase());
			ps.setString(2, pwd);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				u = new User();
				u.setUid(info.getInt(1));
				u.setUname(info.getString(2));
				u.setFirstname(info.getString(4));
				u.setLastname(info.getString(5));
				u.setEmail(info.getString(6));
				u.setUrid(info.getInt(7));
				user.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			/* previously caught the exception here
			 * but this time i will try to pass it 
			 * up to the service layer 
			 */
			
			
		}
		System.out.println(u.getFirstname() + " " + u.getLastname());
		return u;			
	}
	
	public static void main(String[] args) {
		UserDao u = new UserDao();
		u.findOne("admin","Admin");
		
	}
}