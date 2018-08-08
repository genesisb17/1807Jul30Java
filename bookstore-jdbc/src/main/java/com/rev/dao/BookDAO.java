package com.rev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Book;
import com.rev.util.ConnectionFactory;

public class BookDAO {
	
	public static void main(String[] args) {
		// Lets see this work!
		List<Book> books = findAll();
		for (Book b : books) {
			System.out.println(b);
		}
	}

	public static List<Book> findAll() {
		List<Book> books = new ArrayList<Book>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from book";
			
			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				//iterate through each row of result set
				Book temp = new Book();
				temp.setId(rs.getInt(1));
				temp.setISBN(rs.getString(2));
				temp.setTitle(rs.getString(3));
				temp.setPrice(rs.getString(4));
				temp.setGenre_id(rs.getString(5));
				books.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
}
