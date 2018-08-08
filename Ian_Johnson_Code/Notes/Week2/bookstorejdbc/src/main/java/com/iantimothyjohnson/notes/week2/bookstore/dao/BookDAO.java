package com.iantimothyjohnson.notes.week2.bookstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iantimothyjohnson.notes.week2.bookstore.pojos.Book;
import com.iantimothyjohnson.notes.week2.bookstore.util.ConnectionFactory;

public class BookDAO {
	public List<Book> findAll() {
		List<Book> books = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT book_id, isbn, title, price, genre_id FROM book";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Book tmp = new Book();
				tmp.setId(rs.getInt("book_id"));
				tmp.setIsbn(rs.getString("isbn"));
				tmp.setTitle(rs.getString("title"));
				tmp.setPrice(rs.getDouble("price"));
				tmp.setGenreId(rs.getInt("genre_id"));
				books.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return books;
	}
}
