package com.ex.dao;

import java.sql.Connection;
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
			
			String query = "select * from client order by client_id";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Client_Account_Junction temp = new Client_Account_Junction();
				temp.setClient_id(rs.getInt(1));;
				temp.setAccount_id(2);
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
		// TODO Auto-generated method stub
		return null;
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
