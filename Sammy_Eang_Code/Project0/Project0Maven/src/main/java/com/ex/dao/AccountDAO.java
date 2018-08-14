package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.connectionfactory.ConnectionFactory;
import com.ex.pojo.Account;

public class AccountDAO implements DAO<Account, Integer> {

	//Function to find get all fields and return them to a list
	@Override
	public List<Account> findAll() {
		//New empty list
		List<Account> accounts = new ArrayList<Account>();
		
		//establishing connection
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			//query to retrieve all info
			String query = "select * from account";
			//executes query
			Statement statement = conn.createStatement();
			//takes results and returns into set
			ResultSet rs = statement.executeQuery(query);
			
			//goes through all fields of results
			while(rs.next()) {
				//temporary object
				Account temp = new Account();
				//sets object's id to field's id
				temp.setAccount_id(rs.getInt("account_id"));
				//sets object's id to field's balance
				temp.setBalance(rs.getDouble("balance"));
				//sets object's account type to field's account type
				temp.setAccount_type_id(rs.getInt("account_type_id"));
				//adds entirety of field as an object into array
				accounts.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//returns list created in beginning
		return accounts;
	}

	@Override
	public Account save(Account obj) {
		//New empty account object
		Account account = new Account();
		
		//establish connection
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			//turn off autocommit until we're sure we want to commit
			conn.setAutoCommit(false);
			//prepared statement with blank values for inserting a new field
			String query = "insert into account(balance, account_type_id) values(?, ?)";
			
			//key for auto id generating
			String[] keys = new String[1];
			keys[0] = "account_id";
			
			//load prepared statement and key
			PreparedStatement ps = conn.prepareStatement(query, keys);
			//setting ? values of statement to one passed from object in parameter
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2, obj.getAccount_type_id());
			
			//executes statement
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				//generates id for new account that was inserted
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					account.setAccount_id(pk.getInt(1));
				}
				//commits changes
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return account;
		
		
	}
	
	//function to 'withdraw' money from database
	public void withdraw(double money, int aid) {
		
		//establish connection
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			//turns off auto commit
			conn.setAutoCommit(false);
			//statement to call pre-existing procedure in sql database
			String query = "{call withdraw(?, ?)}";
			
			//loads statement
			CallableStatement cs = conn.prepareCall(query);
			//loads values into ? fields of callable statement
			cs.setDouble(1, money);
			cs.setInt(2, aid);
			
			//executes statement
			int rows = cs.executeUpdate();
			
			//commits changes
			if(rows != 0) {			
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deposit(double money, int aid) {
		
		//same as withdraw but changes one line to call a different procedure in sql (withdraw -> deposit)
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			   conn.setAutoCommit(false);
				String query = "{call deposit(?, ?)}";
				
				CallableStatement cs = conn.prepareCall(query);
				cs.setDouble(1, money);
				cs.setInt(2, aid);
				
				int rows = cs.executeUpdate();
				
				if(rows != 0) {			
					conn.commit();
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
