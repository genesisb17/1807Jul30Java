package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.ex.pojos.Login;
import com.ex.util.ConnectionFactory;

public class CreateDao implements DAO<Login, Integer>{
	
	Statement stmt = null;

	//Method to insert a row when the account is made. 
	public Login insert(String username, String password, String firstname, String lastname) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			conn.setAutoCommit(false);
			System.out.println("One moment, creating account.");
		      stmt = conn.createStatement();
		      
		      String sql = "INSERT INTO login (firstname, lastname, "
			      		+ "username, userpassword, accountid)"
			      		+ "VALUES(" + "'" + firstname + "'" + ", " + "'" + lastname + "'" + ", "
			      		+ "'" + username + "'" + ", " + "'" + password + "'" + ", "
			      		+"accountid_gen.nextval" + ")";
		      
		      stmt.executeUpdate(sql);
		      
		      System.out.println("Account created...\n"
		      		+ "Initializing bank account information.\n");
		 
		      CallableStatement cs = null;
		      cs = conn.prepareCall("{call initial_account_setup}");
		      cs.execute();
		      
		      System.out.println("Your account has been successfully created.\n"
		      		+ "Congratulations!\n\n");
		      
		      cs.close();
		      stmt.close();
		   }catch(SQLException se){
		      System.out.println("Too many characters.\n"
		      		+ "Make sure that first name is less than 25 characters,\n"
		      		+ "last name is less than 25 characters,\n"
		      		+ "username is less then 20 characters,\n"
		      		+ "and password is less than 20 characters.\n\n");
		   }catch(Exception e){
		      System.out.println("Error with one or more inputs.");
		   }
		return null;
	}


	@Override
	public List<Login> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login findOne(Integer id) {
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
	public Login insert(Login obj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Login findOne(Login obj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Login findPw(Login obj) {
		// TODO Auto-generated method stub
		return null;
	}
}