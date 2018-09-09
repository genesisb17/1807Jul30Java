package com.reimb.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reimb.pojos.Users;
import com.reimb.util.ConnectionFactory;

public class UserDao implements Dao<Users, Integer>{

	@Override
	public Users save(Users u) {

	        try(Connection conn = ConnectionFactory.getInstance().getConnection();){
	            conn.setAutoCommit(false);
	            String query = "insert into ers_users(users_id, user_role_id, "
	                    + "user_email, username, password, firstname, lastname)"
	                    + " values(?, ?, ?, ?, ?, ?, ?)";

	            PreparedStatement ps = conn.prepareStatement(query);
	            ps.setInt(1, u.getUsersid());
	            ps.setInt(2, u.getUserroleid());
	            ps.setString(3, u.getUseremail());
	            ps.setString(4, u.getUsername());
	            ps.setString(5, u.getPassword());
	            ps.setString(6, u.getFirstname());
	            ps.setString(7, u.getLastname());

	            ps.executeQuery();

	            CallableStatement cs = 
	                    conn.prepareCall("{call ERS_USER_SETUP (?)}");

	            cs.setString(1, u.getUsername());

	            cs.executeUpdate();

	            conn.commit();


	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return u;
	    }
	
	@Override
	public Users findOne(Integer id) {
		Users user = new Users();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql = "select * from ers_users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet info= ps.executeQuery();

			while(info.next()){
				user.setUsersid(info.getInt(1));
				user.setUserroleid(info.getInt(2));
				user.setUseremail(info.getString(3));
				user.setUsername(info.getString(4));
				user.setPassword(info.getString(5));
				user.setFirstname(info.getString(6));
				user.setLastname(info.getString(7));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public List<Users> findAll() {
		List<Users> user = new ArrayList<Users>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql = "select * from ers_users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				Users temp = new Users();
				temp.setUsersid(info.getInt(1));
				temp.setUserroleid(info.getInt(2));
				temp.setUseremail(info.getString(3));				
				temp.setUsername(info.getString(4));
				temp.setPassword(info.getString(5));
				temp.setFirstname(info.getString(6));
				temp.setLastname(info.getString(7));
				
				user.add(temp);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Users findPw(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users findOne(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users insert(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users update(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Users obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Users> findAll(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users saveAnother(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getAll(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getPend(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getFnPend(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getPast(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
