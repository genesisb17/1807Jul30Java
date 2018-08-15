package com.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.pojo.AccountType;
import com.bank.util.ConnectionFactory;


public class AccountTypeDao {
	
	public List<AccountType> typesOfAccounts() {
		AccountType at = null;
		List<AccountType> acntype = new ArrayList<AccountType>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ACCOUNT_TYPE";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {
				at = new AccountType();
				at.setAtid(rs.getInt(1));
				at.setaType(rs.getString(2));
				acntype.add(at);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acntype;
	}

}
