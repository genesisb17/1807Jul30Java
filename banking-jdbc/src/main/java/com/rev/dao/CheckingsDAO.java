package com.rev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rev.pojos.Checkings;
import com.rev.pojos.Users;
import com.rev.util.ConnectionFactory;

public class CheckingsDAO {

	public Checkings doesAccountExist(Users user) {
		Checkings c = null;
		
		try ( Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CHECKINGS WHERE USERID = '" + user.getUserid() + "'");
			
			while (rs.next()) {
				c = new Checkings();
				c.setCheckingsid(rs.getInt(1));
				c.setUserid(rs.getInt(2));
				c.setTotal(rs.getDouble(3));
			}
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (c == null) {
			return null;
		}
		
		return c;
	}

}
