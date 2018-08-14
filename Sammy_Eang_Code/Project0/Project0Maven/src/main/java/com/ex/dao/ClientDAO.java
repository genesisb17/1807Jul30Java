package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.connectionfactory.ConnectionFactory;
import com.ex.pojo.Client;

public class ClientDAO implements DAO<Client, Integer>{
	
	//Basically all of what is done here is basically the same as what 
	//is done in the AccountDao class so look there for reference
	@Override
	public List<Client> findAll() {
		
		List<Client> clients = new ArrayList<Client>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "select * from client order by client_id";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Client temp = new Client();
				temp.setClient_id(rs.getInt(1));
				temp.setClient_first_name(rs.getString(2));
				temp.setClient_last_name(rs.getString(3));
				temp.setUsername(rs.getString(4));
				temp.setPw(rs.getString(5));
				clients.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public Client save(Client obj) {
		
		Client client = new Client();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			conn.setAutoCommit(false);
			String query = "insert into client(client_first_name, client_last_name, username, pw) values(?, ?, ?, ?)";
			
			String[] keys = new String[1];
			keys[0] = "client_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, obj.getClient_first_name());
			ps.setString(2, obj.getClient_last_name());
			ps.setString(3, obj.getUsername());
			ps.setString(4, obj.getPw());

			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					client.setClient_id(pk.getInt(1));
				}
				
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return client;
	}

}
