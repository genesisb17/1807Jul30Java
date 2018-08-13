package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				temp.setId(rs.getInt("account_id"));
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
				a.setId(info.getInt(1));
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
			ps.setInt(1, a.getId());
			ps.setInt(2,  a.getAccountTypeId());
			ps.setDouble(3, a.getBalance());
			ps.setInt(4,  a.getClientId());
			
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					//System.out.println(pk.getInt(1));
					aa.setId(pk.getInt(1));
				}
				conn.commit();
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return aa;
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
				temp.setId(rs.getInt("account_type"));
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
	
	public Account update(Account obj) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "update accounts set balance = ? where account_id = ?";
			
			String[] keys = {"account_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2, obj.getId());
			
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

	@Override
	public Account findOne(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
