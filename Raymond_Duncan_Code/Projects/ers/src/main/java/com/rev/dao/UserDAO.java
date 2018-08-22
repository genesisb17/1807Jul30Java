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

public class UserDAO implements DAO<User, Long> {

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "GET * FROM ers_user";
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()) {
				User temp = new User();
				temp.setUser_id(rs.getLong("ers_user_id"));
				temp.setUsername(rs.getString("ers_username"));
				temp.setFirstname(rs.getString("ers_firstname"));
				temp.setLastname(rs.getString("ers_lastname"));
				temp.setEmail(rs.getString("ers_email"));
//				temp.setCompany_role(rs.getString(columnIndex));
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
			String query = "GET * FROM ers_user WHERE ers_user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setUser_id(rs.getLong("ers_user_id"));
				user.setUsername(rs.getString("ers_username"));
				user.setFirstname(rs.getString("ers_firstname"));
				user.setLastname(rs.getString("ers_lastname"));
				user.setEmail(rs.getString("ers_email"));
//				user.setCompany_role(rs.getString(columnIndex));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User save(User t) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "UPDATE ers_user(ers_password,ers_email) VALUES(?,?) WHERE ers_user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getPassword());
			ps.setString(2, t.getEmail());
			ps.setLong(3, t.getUser_id());
			int numRowsEffected = ps.executeUpdate();
			//TODO Add some database update logging here
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return t;
	}

}
