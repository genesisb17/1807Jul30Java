package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.rev.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;
import pojo.Account;
import pojo.Client;

public class AccountDAO implements DAO<Account, Integer> {
	
	public List<Account> getAll() {
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_accounts(?)}";
			CallableStatement cs = conn.prepareCall(sql);
	
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Account temp = new Account();
				temp.setAccountId(rs.getInt("account_id"));
				temp.setAccountTypeId(rs.getInt("account_type_id"));
				temp.setBalance(rs.getDouble("balance"));
				temp.setClientId(rs.getInt("client_id"));

				//System.out.println(temp);
				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	public Account findOne(Integer id) {
		Account a = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Accounts where Account_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				a = new Account();
				a.setAccountId(info.getInt(1));
				a.setAccountTypeId(info.getInt(2));
				a.setBalance(info.getDouble(3));
				a.setClientId(info.getInt(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	

	public Account save(Account a) {
		Account aa = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "insert into accounts(account_id, account_type_id,balance,client_id) values(?,?,?,?)";
			
			String[] keys = {"account_id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, a.getAccountId());
			ps.setInt(2,  a.getAccountTypeId());
			ps.setDouble(3, a.getBalance());
			ps.setInt(4,  a.getClientId());
			
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.getInt(1) + " the key");
					a.setAccountId(pk.getInt(1));
					a.setClientId(4);
					
				}
				conn.commit();
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(a.getClientId()+ " ACCOUNT PASSED");
		System.out.println(aa.getClientId()+ " ACCOUNT RETURNED");
		return a;
	}
	public List<Account> getAccounts(Client c) {
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_user_Accounts(?)}";
			CallableStatement cs = conn.prepareCall(sql);
	
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Account temp = new Account();
				temp.setAccountId(rs.getInt("account_type"));
				temp.setBalance(rs.getDouble("balance"));
				temp.setClientId(rs.getInt("client_id"));

				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	public Account update(Account obj) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "update accounts set balance = ? where client_id = ?";// changed from account_idi
			
			String[] keys = {"account_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2, obj.getClientId());//			change from getId
			
			ps.executeQuery();
			conn.commit();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	public void delete(Account obj) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Account> findAll(Account obj) {
		//gives this method the ability to make this any type of list. you don't need to worry of the type of 
				//list when you call this method.
				List<Account> accounts = new ArrayList<Account>();
				try (Connection conn = ConnectionFactory
						.getInstance().getConnection()){ //singleton so you don't use 'new'
					String query = "select * from accounts";
					//STATEMENT INTERFACE
					//Connection is really important interface. you can only instantiate things that implement connection
					Statement statement = conn.createStatement();
					
					//now get result set. (any executeUpdate is going to return number of rows affected)
					ResultSet rs = statement.executeQuery(query);
					
					//iterate through result set. each row
					while(rs.next()) {
						Account temp = new Account();
						temp.setAccountId(rs.getInt(1)); //there's no 0 index in the table. gets first column which are id's
						//temp.setAccount(rs.getString(2)); //gets 2nd column which are the names of the genres. you can put 
														//the label of the column as well instead of the col number
						accounts.add(temp);
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
				return accounts;
	}

	@Override
	public Account findOne(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
