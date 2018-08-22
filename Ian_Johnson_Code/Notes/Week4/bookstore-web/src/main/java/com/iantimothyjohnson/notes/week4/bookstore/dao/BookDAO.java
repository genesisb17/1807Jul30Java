package com.iantimothyjohnson.notes.week4.bookstore.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.iantimothyjohnson.notes.week4.bookstore.pojos.Book;
import com.iantimothyjohnson.notes.week4.bookstore.util.ConnectionFactory;

public class BookDAO implements DAO<Book, Integer> {
	@Override
	public List<Book> findAll() {
		// Let's use a callable statement for this one.
		List<Book> books = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			final String sql = "{CALL get_all_books(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.REF_CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);
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
}
