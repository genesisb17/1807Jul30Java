package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.service.AccountManager;
import com.revature.utils.ConnectionFactory;

public class AccountManagerDAO implements DAO<AccountManager, Long> {

	@Override
	public List<AccountManager> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountManager getOne(Long uid) {
		AccountManager am = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM BankUser WHERE user_id = ?";
			
			PreparedStatement ps = conn.prepareCall(query);
			ps.setLong(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				am = new AccountManager(
						rs.getLong("user_id"),
						AccountManager.toNameTitle(rs.getString("title")),
						rs.getString("firstname"),
						rs.getString("lastname")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return am;
	}

	@Override
	public AccountManager save(AccountManager am) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "INSERT INTO BankUser VALUES(?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareCall(query);
			ps.setLong(1, am.getUserID());
			ps.setString(2, am.getNameTitle().toString());
			ps.setString(3, am.getFirstName());
			ps.setString(4, am.getLastName());
			ps.setDouble(5, am.getTotalBalance());
			int numRowsEffected = ps.executeUpdate();
			if(numRowsEffected > 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return am;
	}

	@Override
	public AccountManager update(AccountManager am) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountManager delete(AccountManager am) {
		// TODO Auto-generated method stub
		return null;
	}

}
