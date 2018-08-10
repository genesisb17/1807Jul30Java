package com.rev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojo.Genre;
import com.rev.util.ConnectionFactory;

public class GenreDAO {
	
	public static void main(String[] args) {
		//LETS SEE THIS WORK!
		List<Genre> genres = findAll();
		for(Genre g : genres) {
			System.out.println(g);
		}
	}
	
	public static List<Genre> findAll(){
		List<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnections()){
			String query = "select * from genre";
	
			// interfaces
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Genre temp = new Genre();
				temp.setId(rs.getInt(1));
				String name = rs.getString(2);
				temp.setName(name);
				genres.add(temp);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return genres;
	}

}