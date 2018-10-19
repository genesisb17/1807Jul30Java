package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.User;
import com.rev.utils.ConnectionFactory;
import com.rev.utils.UserCompanyRole;

public class UserDAO implements DAO<User, Long> {

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ers_user";
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()) {
				User temp = new User();
				temp.setUserID(rs.getLong("ers_user_id"));
				temp.setUsername(rs.getString("ers_username"));
				temp.setPassword(rs.getString("ers_password"));
				temp.setFirstname(rs.getString("ers_firstname"));
				temp.setLastname(rs.getString("ers_lastname"));
				temp.setEmail(rs.getString("ers_email"));
				temp.setCompanyRole(UserCompanyRole.fromInt(rs.getInt("ers_company_role")));
				temp.setCreator(rs.getLong("ers_creator"));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getOne(Long id) {
		User user = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ers_user WHERE ers_user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUserID(id);
				user.setUsername(rs.getString("ers_username"));
				user.setPassword(rs.getString("ers_password"));
				user.setFirstname(rs.getString("ers_firstname"));
				user.setLastname(rs.getString("ers_lastname"));
				user.setEmail(rs.getString("ers_email"));
				user.setCompanyRole(UserCompanyRole.fromInt(rs.getInt("ers_company_role")));
				user.setCreator(rs.getLong("ers_creator"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User getOne(String username) {
		User user = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ers_user WHERE ers_username = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUserID(rs.getLong("ers_user_id"));
				user.setUsername(rs.getString("ers_username"));
				user.setPassword(rs.getString("ers_password"));
				user.setFirstname(rs.getString("ers_firstname"));
				user.setLastname(rs.getString("ers_lastname"));
				user.setEmail(rs.getString("ers_email"));
				user.setCompanyRole(UserCompanyRole.fromInt(rs.getInt("ers_company_role")));
				user.setCreator(rs.getLong("ers_creator"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User save(User t) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "UPDATE ers_user SET ers_password=?,ers_email=?,ers_company_role=? WHERE ers_user_id = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getPassword());
			ps.setString(2, t.getEmail());
			ps.setInt(3, UserCompanyRole.valueOf(t.getCompanyRole()).ordinal());
			ps.setLong(4, t.getUserID());
			int numRowsEffected = ps.executeUpdate();
			if(numRowsEffected == 1) return t;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User saveNew(User t) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "INSERT INTO ers_user(ers_user_id,ers_username,ers_password,ers_firstname,ers_lastname,ers_email,ers_company_role) VALUES(NULL,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getFirstname());
			ps.setString(4, t.getLastname());
			ps.setString(5, t.getEmail());
			ps.setInt(6, UserCompanyRole.valueOf(t.getCompanyRole()).ordinal());
			int numRowsEffected = ps.executeUpdate();
			if(numRowsEffected == 1) return t;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		UserDAO udao = new UserDAO();
		System.out.println(udao.getAll().toString());
		System.out.println(udao.getOne(1L));
	}
}
