package com.rev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Author;
import com.rev.util.ConnectionFactory;

public class AuthorDAO implements DAO<Author, Integer> {
	/*
	 * Author_ID number(10) PRIMARY KEY, 
	 * First_Name varchar2(256) NOT NULL,
	 * Last_Name varchar2(256), 
	 * Biography varchar2(2048)
	 */

	//PREPARED STATEMENT
	@Override
	public List<Author> findAll() {
		List<Author> authors = new ArrayList<Author>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from author";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Author temp = new Author();
				temp.setAuthorID(rs.getInt(1)); 
				temp.setFirstName(rs.getString(2)); 
				temp.setLastName(rs.getString(3)); 
				temp.setBio(rs.getString(4)); 
				authors.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authors;
	}

	@Override
	public Author findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author save(Author obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author update(Author obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Author obj) {
		// TODO Auto-generated method stub
		
	}

}
