package com.rev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Book;
import com.rev.pojos.Genre;
import com.rev.util.ConnectionFactory;

public class BookDAO implements Dao<Book, Integer> {
	
	@Override
	public List<Book> findAll() {
		List<Book> books = new ArrayList<Book>();
		
		return null;
	}

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book save(Book obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book update(Book obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Book obj) {
		// TODO Auto-generated method stub
		
	}

//	public static List<Book> findAll() {
//		List<Book> books = new ArrayList<Book>();
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			String query = "select * from book";
//			
//			// STATEMENT INTERFACE
//			Statement statement = conn.createStatement();
//			ResultSet rs = statement.executeQuery(query);
//			
//			while(rs.next()) {
//				//iterate through each row of result set
//				Book temp = new Book();
//				temp.setId(rs.getInt(1));
//				temp.setISBN(rs.getString(2));
//				temp.setTitle(rs.getString(3));
//				temp.setPrice(rs.getString(4));
//				temp.setGenre_id(rs.getString(5));
//				books.add(temp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return books;
//	}
}
