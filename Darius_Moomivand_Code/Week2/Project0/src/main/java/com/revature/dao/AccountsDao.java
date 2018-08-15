package com.revature.dao;

import com.revature.pojo.Accounts;
import com.revature.pojo.AllAccounts;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class AccountsDao implements Dao<Accounts, Integer>{

	@Override
	public List<Accounts> findAll() {
		List<Accounts> accounts = new ArrayList<Accounts>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "Select * From accounts";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Accounts temp = new Accounts();
				temp.setAccId(rs.getInt("Account_Id"));
				temp.setBalance(rs.getDouble("Balance"));
				temp.setAccountTypeId(rs.getInt("Acc_Type_Id"));
				accounts.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return accounts;
		
	}

	@Override
	public Accounts findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accounts save(Accounts obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "INSERT INTO accounts(balance, acc_type_id) values(?,?)";
			String[] keys = new String[1];
			keys[0] = "account_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2, obj.getAccountTypeId());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setAccId(pk.getInt(1));
				}
				
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		return obj;
	}


		

	@Override
	public void delete(Accounts obj) {
		// TODO Auto-generated method stub
		
	
	}

	@Override
	public Accounts update(Accounts obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "UPDATE ACCOUNTS SET BALANCE = ? "
					+ "WHERE ACCOUNTS.ACCOUNT_ID =?";

			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2, obj.getAccId());
			ps.executeUpdate();
							
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;	
		
	}
	
	public String time() {
		String transactionId = "";
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "{ ? = call getDate}";
			
			CallableStatement cs = conn.prepareCall(query);
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.execute();
			
			transactionId = cs.getNString(1);
			
			//System.out.println(transactionId);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return transactionId;
		
	}
}
