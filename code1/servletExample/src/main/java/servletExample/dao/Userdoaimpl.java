package servletExample.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import servletExample.pojo.User;
import servletExample.pojo.UserInfo;
import servletExample.util.ConnectionUtil;

public class Userdoaimpl implements UserDao {
	private static Userdoaimpl instance;
	private Userdoaimpl() {
		
	}
	
	public static Userdoaimpl getInstance() {
		if (instance == null) 
			instance = new Userdoaimpl();
			return instance;
		
	}
	@Override
	public String getPasswordHash(User user) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement cs = conn.prepareStatement("SELECT GET_USER_HASH(?,?) as hash FROM DUAL");
			cs.setString(++index, user.getUsername());
			cs.setString(++index, user.getPassword());
			ResultSet rs = cs.executeQuery();
			if(rs.next())
				return rs.getString("hash");
			
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}
		
		return null;
	}

	@Override
	public UserInfo getUserInfo(String username) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM example_user_information WHERE USERNAME = ?");
			ps.setString(++index, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			return new UserInfo(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4));
		
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}
		
		return null;
	

	}
	
	public User getUser(String username) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM EXAMPLE_USERs WHERE USERNAME = ?");
			ps.setString(++index,  username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return new User(rs.getString(1), rs.getString(2));
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}
		
		return null;
		
	}
	
	
}
