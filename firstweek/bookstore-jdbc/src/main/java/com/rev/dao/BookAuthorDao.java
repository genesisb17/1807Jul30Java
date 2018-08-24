package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rev.pojo.Author;
import com.rev.pojo.Book;
import com.rev.util.ConnectionFactory;

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