package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Accounts;
import com.revature.pojo.Client;
import com.revature.pojo.ClientAccount;
import com.revature.util.ConnectionFactory;

public class ClientAccountDoa implements Dao<ClientAccount, Integer>{

	@Override
	public List<ClientAccount> findAll() {
		List<ClientAccount> clientAcc = new ArrayList<ClientAccount>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "Select * From client_account";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				ClientAccount temp = new ClientAccount();
				temp.setClientId(rs.getDouble("client_id"));
				temp.setAccountId(rs.getDouble("account_id"));
				clientAcc.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return clientAcc;
	}

	@Override
	public ClientAccount findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientAccount save(ClientAccount obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "INSERT INTO client_account(client_id, account_id) values(?,?)";
			String[] keys = new String[1];
			keys[0] = "account_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setDouble(1, obj.getClientId());
			ps.setDouble(2, obj.getAccountId());
			
			int rows = ps.executeUpdate();
			
/*			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setAccId(pk.getInt(1));
				}
				
				conn.commit();
			}
*/
		} catch (SQLException e) {
			e.printStackTrace();

		}
			
		
		return obj;
	}

	@Override
	public ClientAccount update(ClientAccount obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ClientAccount obj) {
		// TODO Auto-generated method stub
		
	}

}
