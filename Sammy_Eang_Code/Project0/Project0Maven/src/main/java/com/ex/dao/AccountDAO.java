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

	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "select * from account";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Account temp = new Account();
				temp.setAccount_id(rs.getInt("account_id"));
				temp.setBalance(rs.getDouble("balance"));
				temp.setAccount_type_id(rs.getInt("account_type_id"));
				accounts.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account findOne(Integer id) {
		
		return null;
	}

	@Override
	public Account save(Account obj) {
		Account account = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			conn.setAutoCommit(false);
			String query = "insert into account(balance, account_type_id) values(?, ?)";
			
			String[] keys = new String[1];
			keys[0] = "account_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2, obj.getAccount_type_id());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					account.setAccount_id(pk.getInt(1));
				}
				
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return account;
		
		
	}

	@Override
	public Account update(Account obj) {
		
		return null;
	}

	@Override
	public void delete(Account obj) {
		
		
	}
	
	public void withdraw(double money, int aid) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			   conn.setAutoCommit(false);
				String query = "{call withdraw(?, ?)}";
				
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
	
public void deposit(double money, int aid) {
		
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
