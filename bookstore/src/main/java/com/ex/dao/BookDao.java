package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Book;
import com.ex.util.ConnectionFactory;

public class BookDao implements Dao<Book, Integer> {

	public List<Book> getAll() {
		List<Book> books = new ArrayList<Book>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from book";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {// book_id, isbn, title, price, genre
				Book temp = new Book();
				temp.setId(rs.getInt(1));
				temp.setIsbn(rs.getString(2));
				temp.setTitle(rs.getString(3));
				temp.setPrice(rs.getDouble(4));
				temp.setGenreId(rs.getInt(5));
				books.add(temp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	public Book findOne(Integer id) {
		Book book = new Book();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql = "select * from book where book_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info= ps.executeQuery();

			while(info.next()){
			book.setId(info.getInt(1));
			book.setIsbn(info.getString(2));
			book.setTitle(info.getString(3));
			book.setPrice(info.getDouble(4));
			book.setGenreId(info.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	public Book save(Book obj) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into book(isbn, title, price, genre_id) "
					+ "values(?,?, ?, ?)";
			
			String[] keys = new String[1];
			keys[0] = "book_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, obj.getIsbn());
			ps.setString(2, obj.getTitle());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4, obj.getGenreId());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setId(pk.getInt(1));
				}
				
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Book update(Book book) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			String query = "update book set isbn = ?, title = ?, price=?, genre_id= ? where book_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, book.getIsbn() );
			ps.setString(2, book.getTitle());
			ps.setDouble(3, book.getPrice());
			ps.setInt(4, book.getGenreId());
			ps.setInt(5, book.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public boolean isUnique(Book obj) {
		String isbn = obj.getIsbn();
		boolean exists = true;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from book where isbn = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, isbn);
			
			ResultSet info = ps.executeQuery();
			System.out.println("in is unique");
			exists = info.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return !exists;
	}

}