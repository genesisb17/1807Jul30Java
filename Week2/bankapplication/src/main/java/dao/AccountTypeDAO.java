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
import pojo.AccountType;

public class AccountTypeDAO implements DAO<AccountType, Integer> {

	
	public List<AccountType> getAll() {
		List<AccountType> Accounts = new ArrayList<AccountType>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_Account_type(?)}";
			CallableStatement cs = conn.prepareCall(sql);
	
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				AccountType temp = new AccountType(rs.getInt(1), 
						rs.getString(2));
				System.out.println(temp);
				Accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Accounts;
	}
	
	public AccountType findOne(Integer id) {
		AccountType a = new AccountType();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Account_type where Account_type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			info.next();
			a.setId(info.getInt(1));
			a.setAccountType(info.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	

	public AccountType save(AccountType a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "insert into Account_type(account_type_id, account_type) values(?,?)";
			
			String[] keys = {"Account_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, a.getId());
			ps.setString(2,  a.getAccountType());
			
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
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public AccountType update(AccountType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(AccountType obj) {
		// TODO Auto-generated method stub
		
	}

}
