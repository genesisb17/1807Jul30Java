package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rev.ConnectionFactory;
import com.rev.pojos.Book;

import oracle.jdbc.OracleTypes;

public class BookDao implements Dao<Book, Integer>{

	@Override
	public List<Book> getAll() {
		List<Book> books = new ArrayList<Book>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{call get_all_books(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				Book temp = new Book();
				temp.setId(rs.getInt("Book_Id"));
				temp.setIsbn(rs.getString("ISBN"));
				temp.setPrice(rs.getDouble("Price"));
				temp.setTitle(rs.getString("Title"));
				temp.setGenreId(rs.getInt("Genre_ID"));
				books.add(temp);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Book(id, isbn, title, price, g.getId());
	
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
	
}
