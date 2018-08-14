package com.ex.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ex.util.ConnectionFactory;

public class TestQuery {
	public static void main(String[] args) {
		//LETS SEE THIS WORK!
		printAll();
		
	}
	public static void printAll(){
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT USELESS_FUNC(3) FROM DUAL";
			
			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				//iterate through each row of result set
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
