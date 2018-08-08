package com.rev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Genre;
import com.rev.util.ConnectionFactory;

public class GenreDAO {
	
	public static void main(String[] args) {
		// Lets see this work!
		List<Genre> genres = findAll();
		for (Genre g : genres) {
			System.out.println(g);
		}
	}

	public static List<Genre> findAll() {
		List<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from genre";
			
			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				//iterate through each row of result set
				Genre temp = new Genre();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				genres.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genres;
	}
}
