package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.pojos.BankAccount;
import com.bank.util.ConnectionFactory;

public class BankAccountDao implements Dao<BankAccount, Integer> {

	@Override
	public List<BankAccount> findAll() {
		return null;
	}
	
	public List<BankAccount> findAssoc(Integer id) {
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		BankAccount ac = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String query = "SELECT * FROM BANK_ACCOUNT WHERE USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			//System.out.println(ps);
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				ac = new BankAccount();
				ac.setAccountNumber(info.getInt(1));
				ac.setAccountType(info.getString(2));
				ac.setBalance(info.getDouble(3));
				ac.setUserid(info.getInt(4));
				accounts.add(ac);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public BankAccount findOne(Integer id) {
		BankAccount account = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String query = "SELECT * FROM BANK_ACCOUNT WHERE ACCT_NUM = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				account = new BankAccount();
				account.setAccountNumber(info.getInt(1));
				account.setAccountType(info.getString(2));
				account.setBalance(info.getDouble(3));
				account.setUserid(info.getInt(4));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public BankAccount save(BankAccount a) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			
			String query = "INSERT INTO BANK_ACCOUNT(ACCT_TYPE, BALANCE, USER_ID) VALUES(?, ?, ?)";
			
			String[] keys = {"ACCT_NUM"};
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, a.getAccountType());
			ps.setDouble(2, a.getBalance());
			ps.setInt(3, a.getUserid());
			
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected>0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					a.setUserid(pk.getInt(1));
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public BankAccount update(BankAccount a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "UPDATE BANK_ACCOUNT SET BALANCE = ? where ACCT_NUM = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, a.getBalance());
			ps.setInt(2, a.getAccountNumber());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void delete(BankAccount obj) {
		// TODO Auto-generated method stub
	}
	

}