package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.revature.exceptions.QueryFailedException;
import com.revature.pojos.Transaction;
import com.revature.utils.ConnectionFactory;

public class TransactionDAO implements DAO<Transaction,Long> {
	
	public static void main(String[] args) {
		TransactionDAO tdao = new TransactionDAO();
		for(Transaction t:tdao.getTransactions(1000000000000000L)) {
			System.out.println(t.toString());
		}
	}

	@Override
	public List<Transaction> getAll() {
		return null;
	}

	@Override
	public Transaction getOne(Long accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction save(Transaction t) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "INSERT INTO Transaction VALUES("
					+ "NULL,?,?,?,NULL";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, t.getFromAccount());
			ps.setLong(2, t.getToAccount());
			ps.setDouble(3,t.getAmount());
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected > 0) {
				conn.commit();
			} else throw new QueryFailedException();
			
		} catch (SQLException e) {
//			e.printStackTrace();
		} catch (QueryFailedException e) {
//			e.printStackTrace();
			return null;
		}
		return t;
	}

	@Override
	public Transaction update(Transaction t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction delete(Transaction t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Transaction> getTransactions(long accountNumber){
		List<Transaction> transactions = new LinkedList<Transaction>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM Transaction WHERE from_account = ? ORDER BY transaction_id DESC";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, accountNumber);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Transaction temp = new Transaction(
						rs.getLong("transaction_id"),
						rs.getLong("from_account"),
						rs.getLong("to_account"),
						rs.getDouble("amount"),
						rs.getTimestamp("time")
						);
				transactions.add(temp);
			}
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		return transactions;
	}
	
}
