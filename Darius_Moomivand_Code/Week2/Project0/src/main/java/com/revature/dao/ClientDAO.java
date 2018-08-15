package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Client;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class ClientDAO implements Dao<Client, Integer>{

	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<Client>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "Select * From client";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Client temp = new Client();
				temp.setClientId(rs.getInt("client_id"));
				temp.setFirstName(rs.getString("first_name"));
				temp.setLastName(rs.getString("last_name"));
				temp.setUserName(rs.getString("user_name"));
				temp.setPassword(rs.getString("password"));
				clients.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return clients;
	}		
		

	@Override
	public Client findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client save(Client obj) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "INSERT INTO client(first_name, last_name, user_name, password) "
					+ "values(?,?, ?, ?)";
			
			String[] keys = new String[1];   
			keys[0] = "client_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);	
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getUserName());
			ps.setString(4, obj.getPassword());
			
			int rows = ps.executeUpdate();
			
	

			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setClientId(pk.getInt(1));
					
				}
				
				conn.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return obj;		
		
	}
	

	@Override
	public Client update(Client obj) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public void delete(Client obj) {
		// TODO Auto-generated method stub
		
	}

	public int getClientId(int id) {
		int g = 0;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from genre where genre_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			g = info.getInt(1);

			}
			// more code
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
	
}
