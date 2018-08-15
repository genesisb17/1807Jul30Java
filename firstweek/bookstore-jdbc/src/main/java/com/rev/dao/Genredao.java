package com.rev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojo.Genre;
import com.rev.util.ConnectionFactory;

public class Genredao {
	
	public static List<Genre> findAll() {
		List <Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM GENRE";
			Statement statement = conn.createStatement();
			ResultSet re = statement.executeQuery(query);
			while(re.next()) {
				Genre temp = new Genre();
				temp.setName(re.getString(1));
				int name = re.getInt(2);
				temp.setId(name);
				genres.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genres;
	}
	public static void main(String[] args) {
		List<Genre> genres = findAll();
		for(Genre g : genres) {
			System.out.println(g);
		}
	}

}
