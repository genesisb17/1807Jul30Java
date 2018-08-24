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
	//new user
	public User addOne(User user) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().getConnection();
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
		 
		return user;
	}
	
	
	//user login method checks username and password in the database
	public User findOne(String uname, String pwd) throws SQLException {
		User u = null;
		List<User> user = new ArrayList<User>();
		Connection conn = ConnectionFactory.getInstance().getConnection();
			String sql  = "SELECT U_ID, USERNAME, UPASSWORD, FIRSTNAME, LASTNAME, EMAIL, UR_ID FROM USERS WHERE UPPER(USERNAME) = ? AND UPASSWORD = ?";
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
		return u;			
	
	}
	
}