package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.connectionfactory.ConnectionFactory;
import com.ex.pojo.Client_Account_Junction;

public class JunctionDAO implements DAO<Client_Account_Junction, Integer>{

	@Override
	public List<Client_Account_Junction> findAll() {
		List<Client_Account_Junction> junctions = new ArrayList<Client_Account_Junction>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "select * from client_account";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Client_Account_Junction temp = new Client_Account_Junction();
				temp.setClient_id(rs.getInt(1));
				temp.setAccount_id(rs.getInt(2));
				junctions.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return junctions;
	}

	@Override
	public Client_Account_Junction findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client_Account_Junction save(Client_Account_Junction obj) {
		Client_Account_Junction caj = new Client_Account_Junction();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			conn.setAutoCommit(false);
			String query = "insert into client_account(client_id, account_id) values(?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, obj.getClient_id());
			ps.setInt(2, obj.getAccount_id());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {			
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return caj;
	}

	@Override
	public Client_Account_Junction update(Client_Account_Junction obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Client_Account_Junction obj) {
		// TODO Auto-generated method stub
		
	}

}
