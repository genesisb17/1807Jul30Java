package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.pojos.BankUser;
import com.bank.util.ConnectionFactory;

public class BankUserDao implements Dao<BankUser, Integer> {

	@Override
	public List<BankUser> findAll() {
		List<BankUser> users = new ArrayList<BankUser>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String query = "SELECT * FROM BANK_USERS ORDER BY USERNAME ASC";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				//iterate through each row of result set
				BankUser temp = new BankUser();
				temp.setId(rs.getInt(1));
				temp.setFirstName(rs.getString(2));;
				temp.setLastName(rs.getString(3));
				temp.setUsername(rs.getString(4));
				temp.setPassword(rs.getString(5));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public BankUser findOne(Integer id) {
		BankUser user = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()) {
			String sql = "SELECT * FROM BANK_USERS WHERE USER_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				user = new BankUser();
				user.setId(info.getInt(1));
				user.setFirstName(info.getString(2));
				user.setLastName(info.getString(3));
				user.setUsername(info.getString(4));
				user.setPassword(info.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public BankUser save(BankUser u) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()) {
			String sql = "INSERT INTO BANK_USERS(FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) VALUES(?, ?, ?, ?)";
			
			String[] keys = {"USER_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					u.setId(pk.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public BankUser update(BankUser obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(BankUser obj) {
		// TODO Auto-generated method stub
		
	}
}