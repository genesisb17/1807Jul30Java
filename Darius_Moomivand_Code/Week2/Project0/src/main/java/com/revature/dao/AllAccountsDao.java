package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.AllAccounts;
import com.revature.pojo.Client;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class AllAccountsDao  implements Dao<AllAccounts, Integer>{

	@Override
	public List<AllAccounts> findAll() {
		List<AllAccounts> tempList = new ArrayList<AllAccounts>();
		
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select cc.first_name, cc.last_name, acc.account_id, acc.balance\r\n" + 
					"from accounts acc \r\n" + 
					"inner join client_account ac on acc.account_id=ac.account_id \r\n" + 
					"inner join client cc on ac.client_id=cc.client_id where ac.client_id =(?);";
			
			CallableStatement cs = conn.prepareCall(query);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				AllAccounts temp = new AllAccounts();
				temp.setFirstName(rs.getString("FIRST_NAME"));
				temp.setLastName(rs.getString("LAST_NAME"));
				temp.setAccId(rs.getInt("ACCOUNT_ID"));
				temp.setBalance(rs.getDouble("BALANCE"));
				tempList.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return tempList;
	}

	@Override
	public AllAccounts findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AllAccounts save(AllAccounts obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AllAccounts update(AllAccounts obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(AllAccounts obj) {
		// TODO Auto-generated method stub
		
	}

}
