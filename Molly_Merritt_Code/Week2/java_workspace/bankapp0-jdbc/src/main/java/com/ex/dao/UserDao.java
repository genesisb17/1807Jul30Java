package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Users;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class UserDao { //implements Dao<Users, Integer> {
	
//	public Users addUser(Users u) {
//		// call save()
//		return save(u);
//	}

//	@Override
	// Users(userID, firstName, lastName, username, password)
	public List<Users> findAll() {
		List<Users> users = new ArrayList<Users>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_users(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				Users temp = new Users();
				temp.setFirstName(rs.getString("firstName"));
				temp.setLastName(rs.getString("lastName"));
				temp.setUserID(rs.getInt("userID"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("password"));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

//	@Override
//	public Users findOne(Integer id) {
//		Users u = null;
//		try(Connection conn = ConnectionFactory
//				.getInstance().getConnection()){
//			String sql = "select * from genre where userid = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//			u = new Users();
//			u.setUserID(rs.getInt("userID"));
//			u.setFirstName(rs.getString("firstName"));
//			u.setLastName(rs.getString("lastName"));
//			u.setUsername(rs.getString("username"));
//			u.setPassword(rs.getString("password"));
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return u;
//	}
	
	public Users findOne(String username, String password) {
		Users u = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			u = new Users();
			u.setUserID(rs.getInt("userID"));
			u.setFirstName(rs.getString("firstName"));
			u.setLastName(rs.getString("lastName"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

//	@Override
	public Users save(Users obj) {
//		System.out.println("Calling UserDao.save()");
//		Users user = new Users();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String query = "INSERT INTO users(userID, firstName, lastName, username,"
					+ "password) " + "VALUES(?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "userID";	// column name where keys are
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			
			ps.setInt(1, obj.getUserID());
			ps.setString(2, obj.getFirstName());
			ps.setString(3, obj.getLastName());
			ps.setString(4, obj.getUsername());
			ps.setString(5, obj.getPassword());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();	// generated keys
				while(pk.next()) {
					obj.setUserID(pk.getInt(1));
//					System.out.println("User ID is: " + obj.getUserID());
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	

//	@Override
	public Users update(Users obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String query = "UPDATE users set firstName = ?, lastName = ?,"
					+ "username = ?, password = ? WHERE userID = ?";
			
			String[] keys = new String[1];
			keys[0] = "userID";	// column name where keys are
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getUsername());
			ps.setString(4, obj.getPassword());
			ps.setInt(5, obj.getUserID());
			
			int rows = ps.executeUpdate();
			System.out.println(rows);
			
			if(rows != 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

//	@Override
	public void delete(Users obj) {
		
	}

}
