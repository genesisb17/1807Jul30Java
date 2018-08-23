package com.ex.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Book;
import com.ex.pojos.Genre;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class BookDao implements Dao<Book, Integer> {

//	@Override
	public List findAll() {
		List<Book> books = new ArrayList<Book>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_books(?)}";	// must call inside curly braces
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				Book temp = new Book();
				temp.setId(rs.getInt("Book_Id"));
				temp.setIsbn(rs.getString("ISBN"));
				temp.setPrice(rs.getDouble("price"));
				temp.setTitle(rs.getString("Title"));
				temp.setGenreId(rs.getInt("BGenre_Id"));
				books.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return books;
	}

//	@Override
	public Book findOne(Integer id) {
		Book b = new Book();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from book where book_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			info.next();
			b.setId(info.getInt(1));
			b.setIsbn(info.getString(2));
			b.setTitle(info.getString(3));
			b.setPrice(info.getDouble(4));
			b.setGenreId(info.getInt(5));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Book save(Book obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String query = "INSERT INTO book(ISBN, Title, Price, bGenre_Id) VALUES(?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "book_ID";	// column name where keys are
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			
			ps.setString(1, obj.getIsbn());
			ps.setString(2, obj.getTitle());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4, obj.getGenreId());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();	// generated keys
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

	@Override
	public Book update(Book obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String query = "INSERT INTO book(ISBN, Title, Price, bGenre_Id) VALUES(?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "bGenre_ID";	// column name where keys are
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			
			ps.setString(1, obj.getIsbn());
			ps.setString(2, obj.getTitle());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4, obj.getGenreId());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();	// generated keys
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

	@Override
	public boolean isUnique(Book obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
