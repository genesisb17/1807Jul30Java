package servletExample.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import servletExample.pojo.Reimbursement;
import servletExample.pojo.User;
import servletExample.pojo.UserInfo;
import servletExample.util.ConnectionUtil;

public class Userdoaimpl implements UserDao {
	
	private static Userdoaimpl instance;
	// empty no args constructor
	private Userdoaimpl() {}
	
	//Checks if an instance exists and if not creates one
	public static Userdoaimpl getInstance() {
		if (instance == null) 
			instance = new Userdoaimpl();
			return instance;
		
	}
	
	//Hashes user password to check against the actual password stored in db
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
	
	
	//Finds all the users information
	@Override
	public UserInfo getUserInfo(String username) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT username, firstname, lastname, email, user_roleS.U_ROLE FROM user_information inner join user_roles on user_information.ur_id=user_roles.ur_id WHERE USERNAME = ?");
			ps.setString(++index, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			return new UserInfo(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5));
		
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}
		
		return null;
	

	}
	
	//Selects the a  user if one exists and gets password ready to be verified.
	public User getUser(String username) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ?");
			ps.setString(++index,  username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return new User(rs.getString(1), rs.getString(2));
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}
		
		return null;
		
	}
	
	
		
	//Adds a new user with the stored procedure
	public void addUser(UserInfo ui) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement cs = conn.prepareCall("{CALL insert_user(?, ?, ?, ?, ?, 1)}");
			System.out.println(ui.getUsername());
			cs.setString(++index, ui.getUsername());
			cs.setString(++index, ui.getPassword());
			cs.setString(++index, ui.getFirstname());
			cs.setString(++index, ui.getLastname());
			cs.setString(++index, ui.getEmail());
			cs.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}

		
	}
	
	public List<UserInfo> getAllUsers() {
		UserInfo u = null;
		List<UserInfo> users = new ArrayList<UserInfo>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT username, firstname, lastname, email, user_roleS.U_ROLE FROM user_information inner join user_roles on user_information.ur_id=user_roles.ur_id where username != 'admin'");
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				u = new UserInfo();
				u.setUsername(info.getString(1));
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setEmail(info.getString(4));
				u.setUr_id(info.getString(5));
				users.add(u);
			}
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}
		return users;
	}
	
	
}
