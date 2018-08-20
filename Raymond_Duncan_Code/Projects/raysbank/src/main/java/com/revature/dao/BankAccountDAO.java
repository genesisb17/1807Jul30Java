package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.exceptions.QueryFailedException;
import com.revature.pojos.BankAccount;
import com.revature.utils.ConnectionFactory;

public class BankAccountDAO implements DAO<BankAccount, Integer> {
	/* Banks have the following parameters:
	 * 		private final AccountType accountType;
	 * 		private final long accountNumber;
	 * 		private final long primaryUserID;
	 * 		private long secondaryUserID;
	 * 		private double balance;
	 * 		private List<Transaction> transactions;
	 * 		private ZonedDateTime openDate;
	 * 		private ZonedDateTime closedDate;
	 * 
	 * Bank Constructor:
	 * Existing account - BankAccount(AccountType accountType, long primaryUserID, long accountNumber, double balance)
	 * New account - BankAccount(AccountType accountType, long accountNumber, long primaryUserID)
	 */
	
	public static void main(String[] args) {
		BankAccountDAO badao = new BankAccountDAO();
		for(BankAccount ba:badao.getAll()) {
			System.out.println(ba.toString());
		}
		
	}

	@Override
	public List<BankAccount> getAll() {
		List<BankAccount> accounts = new LinkedList<BankAccount>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM BankAccount ORDER BY account_number";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				BankAccount temp = new BankAccount(
						BankAccount.toAccountType(rs.getString("account_type")),
						rs.getLong("primary_uid"),
						rs.getLong("account_number"),
						rs.getDouble("balance")
						);
				temp.setSecondaryUserID(rs.getLong("secondary_uid"));
				temp.setOpenDate(rs.getTimestamp("open_date"));
				temp.setClosedDate(rs.getTimestamp("close_date"));
				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public BankAccount getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount save(BankAccount ba) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			// BankAccount(account_number,account_type,primary_uid,secondary_uid,balance,open_date,close_date)
			String query = "INSERT INTO BankAccount VALUES(NULL,?,?,NULL,?,NULL,NULL)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ba.getAccountType().toString());
			ps.setLong(2, ba.getPrimaryUserID());
			ps.setDouble(3, ba.getBalance());
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected > 0) {
				conn.commit();
			} else throw new QueryFailedException();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (QueryFailedException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public BankAccount update(BankAccount ba) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			// BankAccount(account_number,account_type,primary_uid,secondary_uid,balance,open_date,close_date)
			String query = "UPDATE BankAccount SET balance = ? WHERE account_number = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, ba.getBalance());
			ps.setLong(2, ba.getAccountNumber());
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected > 0) {
				conn.commit();
			} else throw new QueryFailedException();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (QueryFailedException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public BankAccount delete(BankAccount ba) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<BankAccount> getBankAccounts(long uid){
		List<BankAccount> accounts = new LinkedList<BankAccount>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM BankAccount WHERE primary_uid = ? OR secondary_uid = ? ORDER BY account_number";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, uid);
			ps.setLong(2, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BankAccount temp = new BankAccount(
						BankAccount.toAccountType(rs.getString("account_type")),
						rs.getLong("primary_uid"),
						rs.getLong("account_number"),
						rs.getDouble("balance")
						);
				temp.setSecondaryUserID(rs.getLong("secondary_uid"));
				temp.setOpenDate(rs.getTimestamp("open_date"));
				temp.setClosedDate(rs.getTimestamp("close_date"));
				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
		
}
