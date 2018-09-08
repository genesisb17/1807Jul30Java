package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ex.pojos.Author;
import com.ex.pojos.Book;
import com.ex.util.ConnectionFactory;

public class BookAuthorDao {
	
	public void add(Author a, Book b) {
		try(Connection c = ConnectionFactory
				.getInstance().getConnection()){
			String sql = 
					"insert into book_author(book_id, author_id)"
					+ " values(?,?)";
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setInt(1, a.getId());
			ps.setInt(2, b.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
