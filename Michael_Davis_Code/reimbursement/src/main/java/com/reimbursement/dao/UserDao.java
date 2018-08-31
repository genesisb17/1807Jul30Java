package com.reimbursement.dao;
import oracle.jdbc.driver.*;
/*
 * 
 * 
 * STILL REFACTORING FROM BOOKDAO 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;
import util.connectionFactory;

import com.reimbursement.*;

public class UserDao implements Dao<User, Integer> {

	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			
			
			
			String query = "select * from ERS_USERS";
			PreparedStatement prep=conn.prepareStatement(query);
			ResultSet rs=prep.executeQuery();

			Statement statement = conn.createStatement();
			//ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {// book_id, isbn, title, price, genre
				User temp = new User();
				temp.setUserid(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setUserpassword(rs.getString(3));
				temp.setFname(rs.getString(4));
				temp.setLname(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setUserrole(rs.getInt(7));
				temp.setUsersalt(rs.getString(8));
				users.add(temp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public String getRoleName(User obj) {
		String name="Default Test";
		
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			String query="select * from ERS_User_Roles where User_Role_Id=? ";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, obj.getUserrole());
			
			ResultSet info = ps.executeQuery();
			
			name=info.getString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return name;
	}
	


	public User findOne(Integer id) {
		User user = new User();

		try(Connection conn = connectionFactory.getInstance().getConnection()){

			String sql = "select * from ERS_USERS where USERID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info= ps.executeQuery();

			while(info.next()){
				user.setUserid(info.getInt(1));
				user.setUsername(info.getString(2));
				user.setUserpassword(info.getString(3));
				user.setFname(info.getString(4));
				user.setLname(info.getString(5));
				user.setEmail(info.getString(6));
				user.setUserrole(info.getInt(7));
				user.setUsersalt(info.getString(8));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public User getByUsername(String name) {
		User user =null;

		try(Connection conn = connectionFactory.getInstance().getConnection()){

			String sql = "select * from ERS_USERS where USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet info= ps.executeQuery();
			
			while(info.next()){
				user=new User();
				
				user.setUserid(info.getInt(1));
				user.setUsername(info.getString(2));
				user.setUserpassword(info.getString(3));
				user.setFname(info.getString(4));
				user.setLname(info.getString(5));
				user.setEmail(info.getString(6));
				user.setUserrole(info.getInt(7));
				user.setUsersalt(info.getString(8));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
@Override
	public User save(User obj) {
		User user = new User();
		
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into ERS_USERS(username,userpassword,userfname,userlname,useremail,userroleid,usersalt) "
					+ "values(?,?,?,?,?,?,?)";
			
			//String[] keys = new String[1];
			//keys[0] = "USERID";
			
			//PreparedStatement ps = conn.prepareStatement(query, keys);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getUserpassword());
			ps.setString(3, obj.getFname());
			ps.setString(4, obj.getLname());
			ps.setString(5, obj.getEmail());
			ps.setInt(6, obj.getUserrole());
			ps.setString(7, obj.getUsersalt());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					user.setUserid(pk.getInt(1));
				}
				
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User update(User obj) {
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			String query = "update ERS_USERS set username = ?,userpassword = ?, userfname=?, userlname = ?,useremail=?"
					+ "userroleid=? WHERE userid = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getUserpassword());
			ps.setString(3, obj.getFname());
			ps.setString(4, obj.getLname());
			ps.setString(5, obj.getEmail());
			ps.setInt(6, obj.getUserrole());
			ps.setInt(7, obj.getUserid());
			
			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean isUnique(User obj) {
		String uname = obj.getUsername();
		boolean exists = true;
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			String query = "select * from ERS_USERS where USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, uname);
			
			ResultSet info = ps.executeQuery();
			System.out.println("in is unique");
			exists = info.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return !exists;
	}

	


}