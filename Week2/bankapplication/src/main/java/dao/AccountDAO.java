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

public class AccountDAO implements DAO<Account, Integer> {
	
	public List<Account> getAll() {
		List<Account> Accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_Account(?)}";
			CallableStatement cs = conn.prepareCall(sql);
	
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Account temp = new Account(rs.getInt(1), 
						rs.getDouble(3), rs.getInt(2));
				System.out.println(temp);
				Accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Accounts;
	}
	
	public Account findOne(Integer id) {
		Account a = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Account where Account_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			info.next();
			a.setId(info.getInt(1));
			a.setAccountTypeId(info.getInt(2));
			a.setBalance(info.getDouble(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	

	public Account save(Account a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "insert into Account(account_id, account_type_id,balance) values(?,?,?)";
			
			String[] keys = {"Account_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, a.getId());
			ps.setInt(2,  a.getAccountTypeId());
			ps.setDouble(2, a.getBalance());
			
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.getInt(1));
					a.setId(pk.getInt(1));
				}
			}
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	
	public Account update(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Account obj) {
		// TODO Auto-generated method stub
		
	}
}
