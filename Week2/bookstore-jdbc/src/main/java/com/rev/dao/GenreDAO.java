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

	public static List<Genre> findAll() {
		//gives this method the ability to make this any type of list. you don't need to worry of the type of 
		//list when you call this method.
		List<Genre> genres = new ArrayList<Genre>();
		try (Connection conn = ConnectionFactory
				.getInstance().getConnection()){ //singleton so you don't use 'new'
			String query = "select * from genre";
			//STATEMENT INTERFACE
			//Connection is really important interface. you can only instantiate things that implement connection
			Statement statement = conn.createStatement();
			
			//now get result set. (any executeUpdate is going to return number of rows affected)
			ResultSet rs = statement.executeQuery(query);
			
			//iterate through result set. each row
			while(rs.next()) {
				Genre temp = new Genre();
				temp.setId(rs.getInt(1)); //there's no 0 index in the table. gets first column which are id's
				temp.setName(rs.getString(2)); //gets 2nd column which are the names of the genres. you can put 
												//the label of the column as well instead of the col number
				genres.add(temp);
			}
			
			/*
			 *create list reference (collection of genres)
			 *try w/ resources. connection is autocloseable
			 *	we only get one connection within the try ()
			 *assigning a variable to whatever query we want to run
			 *statement allows you to run uncompiled sql code
			 *
			 * get the resulting table in resultSet
			 * rs.nex() returns a boolean.
			 * 
			 * make temp vals that you add to arraylist that we return.
			 * within the setters, we use the getters in rs to get the integer from 1/2nd columns
			 * 
			 */
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return genres;
	}
}
