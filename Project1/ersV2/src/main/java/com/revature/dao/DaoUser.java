package com.revature.dao;

import com.revature.dao.Dao;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class DaoUser implements Dao<User, Integer> {

	public static void main(String[] args) {
		DaoUser usr = new DaoUser();
		
		List<User> users = usr.getAll();
		for(User x : users) {
			System.out.println(x);
		}
		
	}
	
	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from ers_users";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				//ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID
				User temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setUserName(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setRoleId(rs.getInt(7));
				users.add(temp);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	


	@Override
	public User save(User obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "Insert into ers_users(ers_username, ers_password, user_first_name "
					+ "user_last_name, user_email, user_role_id) values(?,?,?,?,?,?)";
			String[] keys = new String[1];
			keys[0] = "ers_user_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1,  obj.getUserName());
			ps.setString(2, obj.getPassword());
			ps.setString(3,  obj.getFirstName());
			ps.setString(4, obj.getLastName());
			ps.setString(5, obj.getEmail());
			ps.setInt(6, obj.getRoleId());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setUserId(pk.getInt(1));
				}
				
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public User update(User obj) {
//		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
//			conn.setAutoCommit(false);
//			
//			String query = "update ers_users set"
//			
//			
//			
		return null;
	}

	@Override
	public boolean isUnique(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findPw(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public User findOne(String usr) {
		User temp = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from ers_users where id= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usr);
			ResultSet info= ps.executeQuery();
			
			while(info.next()) {
				temp.setUserId(info.getInt(1));
				temp.setUserName(info.getString(2));
				temp.setPassword(info.getString(3));
				temp.setFirstName(info.getString(4));
				temp.setLastName(info.getString(5));
				temp.setEmail(info.getString(6));
				temp.setRoleId(info.getInt(7));
			}
		} catch(SQLException e) {
				e.printStackTrace();
			
		}
		return temp;
	}

	@Override
	public User insert(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User obj) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public User findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public User findOne(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllOfUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
