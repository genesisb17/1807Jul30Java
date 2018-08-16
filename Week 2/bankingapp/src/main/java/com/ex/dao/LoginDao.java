package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.main.App;
import com.ex.pojos.Login;
import com.ex.util.ConnectionFactory;

public class LoginDao implements DAO<Login, Integer>{

	@Override
	public List<Login> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login findOne(Login check) {
		Login l = check;
		PreparedStatement stmt = null;
		
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			
			stmt = conn.prepareStatement("SELECT username FROM login WHERE username = ?");
			stmt.setString(1, check.getUsername());
			ResultSet rs = stmt.executeQuery();
			rs.next();
			System.out.println(rs.getString(1));
			
			l.setUsername(rs.getString(1));
			
			stmt = conn.prepareStatement("SELECT userpassword FROM login WHERE userpassword = ?");
			stmt.setString(1, check.getUserpassword());
			rs = stmt.executeQuery();
			rs.next();
			
			l.setUserpassword(rs.getString(1));
			
			stmt = conn.prepareStatement("SELECT firstname FROM login WHERE username = ?");
			stmt.setString(1, check.getUsername());
			rs = stmt.executeQuery();
			rs.next();
			
			l.setFirstname(rs.getString(1));
			
			stmt = conn.prepareStatement("SELECT lastname FROM login WHERE username = ?");
			stmt.setString(1, check.getUsername());
			rs = stmt.executeQuery();
			rs.next();
			
			l.setLastname(rs.getString(1));
		}
		catch (SQLException e) {
			System.out.println("Username or password was invalid.\n");
			App.loginMenu();
		}
		
		return l;
	}
	
	public Login findPw(Login f) {
		Login find = f;
		PreparedStatement stmt = null;
		
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			
		stmt = conn.prepareStatement("SELECT userpassword FROM login "
				+ "WHERE username = ?");
		
		stmt.setString(1, find.getUsername());
		ResultSet rs;
		rs = stmt.executeQuery();
		rs.next();
		find.setUserpassword(rs.getString(1));
		
		}
		catch (SQLException e) {
			System.out.println("Username or password was invalid.\n");
		}
		return find;
	}

	@Override
	public Login insert(Login obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login save(Login obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login update(Login obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Login obj) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Login findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login insert(String username, String password, String firstname, String lastname) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
