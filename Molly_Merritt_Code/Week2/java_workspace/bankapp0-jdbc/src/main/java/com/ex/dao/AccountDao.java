package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.pojos.Accounts;
import com.ex.util.ConnectionFactory;

public class AccountDao { // implements Dao<Accounts, Integer> {

//	@Override
	public List<Accounts> findAll() {
		return null;
	}

//	@Override
	public Accounts findOne(Integer id) {
		return null;
	}

//	@Override
	public Accounts save(Accounts obj) {
//		System.out.println("Calling AccountDao.save()");
//		Users user = new Users();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String query = "insert into accounts(accountID, accountNumber, userID, "
					+ "accountType, balance) " + "values(?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "userID";	// column name where keys are
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			
			ps.setInt(1, obj.getAccountID());
			ps.setInt(2, obj.getAccountNumber());
			ps.setInt(3, obj.getUserID());
			ps.setInt(4, obj.getAccountType());
			ps.setDouble(5, obj.getBalance());
			
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
	public Accounts update(int accountNumber, int accountType, double amount) {
		Accounts obj = new Accounts();
		obj.setAccountNumber(accountNumber);
		obj.setAccountType(accountType);
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT balance from accounts where "
					+ "accountNumber = ?";
			
			String[] keys = new String[1];
			keys[0] = "accountID";	// column name where keys are
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			
			ps.setDouble(1, accountNumber);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getDouble("balance") + amount > 0) {
					obj.setBalance(rs.getDouble("balance") + amount);
				} else {
					System.out.println("You do not have enough funds to "
							+ "make this transaction");
					return obj;
				}
			}
			
//			if(rows != 0) {
//				ResultSet rs = ps.getResultSet();
//				obj.setBalance(rs.getDouble(0) + amount);
//				conn.commit();
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			System.out.println("new balance: " + obj.getBalance());
			conn.setAutoCommit(false);
			String query = "UPDATE accounts set balance = ?"
					+ "where accountNumber = ? and accountType = ?";
			
			String[] keys = new String[1];
			keys[0] = "accountID";	// column name where keys are
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2,  obj.getAccountNumber());
			ps.setInt(3,  obj.getAccountType());
			
			int rows = ps.executeUpdate();
//			System.out.println(rows);
			
			if(rows != 0) {
				conn.commit();
			}
			String newBalance = String.format("%.2f", obj.getBalance());
			System.out.println("Transaction complete. Your "
					+ "new balance is $" + newBalance);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
//	public Accounts withdraw(Accounts acc, double amount) {
//		acc.setBalance(acc.getBalance() - amount);
//		return update(acc);
//	}
//	
//	public Accounts deposit(Accounts acc, double amount) {
//		acc.setBalance(acc.getBalance() + amount);
//		return update(acc);
//	}

//	@Override
	public void delete(Accounts obj) {
		
	}

}
