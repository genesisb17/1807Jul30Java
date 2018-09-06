package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.User;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class UserDao implements Dao<User, Integer>{
	
	// select count(1) from ...
	
	
	
	public String getPasswordHash(User user) {
		try (Connection conn = ConnectionFactory.getConnection()) {	// try with resources
			PreparedStatement stmt = conn.prepareStatement("select GET_USER_HASH(?,?) AS HASH from dual");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) { return rs.getString("HASH"); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findOne(String username, String password) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_users "
					+ "WHERE ers_username = ? and ers_password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findOne(String username) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_users "
					+ "WHERE ers_username = ?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_users(?)}";	// must call inside curly braces
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				User temp = new User();
				temp.setId(rs.getInt("ERS_USERS_ID"));
				temp.setUsername(rs.getString("ERS_USERNAME"));
				temp.setPassword(rs.getString("ERS_PASSWORD"));
				temp.setFirstname(rs.getString("USER_FIRST_NAME"));
				temp.setLastname(rs.getString("USER_LAST_NAME"));
				temp.setEmail(rs.getString("USER_EMAIL"));
				temp.setRoleId(rs.getInt("USER_ROLE_ID"));
				users.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	@Override
	public User findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String query = "INSERT INTO ers_users(ers_username, ers_password, user_first_name, "
					+ "user_last_name, user_email, user_role_id) VALUES(?,?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "ERS_USERS_ID";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstname());
			ps.setString(4, obj.getLastname());
			ps.setString(5, obj.getEmail());
			ps.setInt(6, obj.getRoleId());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setId(pk.getInt(1));
				}
				conn.commit();
				System.out.println("User added");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public User update(User obj) {
		return null;
	}

	@Override
	public boolean isUnique(User obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		UserDao uDao = new UserDao();
//		User user = new User();
//		user.setUsername("mollymerritt");
//		user.setPassword("password");
//		String username = user.getUsername();
//		String password = uDao.getPasswordHash(user);
//		User u = uDao.findOne(username, password);
//		System.out.println(u.getFirstname() + " " + u.getLastname());
		
		User user = new User();
		user.setUsername("uname");
		user.setPassword("pwd");
		user.setFirstname("fn");
		user.setLastname("ln");
		user.setEmail("em@gmail.com");
		user.setRoleId(1);
		uDao.save(user);
	}

}
