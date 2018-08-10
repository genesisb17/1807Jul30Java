package com.iantimothyjohnson.notes.week2.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iantimothyjohnson.notes.week2.bookstore.pojos.Author;
import com.iantimothyjohnson.notes.week2.bookstore.util.ConnectionFactory;

public class AuthorDAO implements DAO<Author, Integer> {
	@Override
	public List<Author> findAll() {
		List<Author> authors = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT author_id, first_name, last_name, bio FROM author";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Author tmp = new Author();
				tmp.setId(rs.getInt("author_id"));
				tmp.setFirstName(rs.getString("first_name"));
				tmp.setLastName(rs.getString("last_name"));
				tmp.setBio(rs.getString("bio"));
				authors.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return authors;
	}

	@Override
	public Author save(Author a) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// We don't want our connection to auto-commit after TX is complete;
			// instead; we'd like to validate before committing.
			conn.setAutoCommit(false);
			final String sql = "INSERT INTO author(first_name, last_name, bio)" + "VALUES(?, ?, ?)";
			// Code to get back auto-generated PK (other columns can be
			// auto-generated too).
			String[] keys = { "author_id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, a.getFirstName());
			ps.setString(2, a.getLastName());
			ps.setString(3, a.getBio());
			int numRowsAffected = ps.executeUpdate();
			if (numRowsAffected > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					a.setId(pk.getInt(1));
				}
				// Make sure to commit our changes so they will be saved to the
				// DB.
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public Author findOne(Integer id) {
		Author a = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// We don't include the semicolon in our query.
			String query = "SELECT * FROM author WHERE author_id = ?";
			// Statement interface:
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			rs.next();
			a = new Author();
			a.setId(rs.getInt("author_id"));
			a.setFirstName(rs.getString("first_name"));
			a.setLastName(rs.getString("last_name"));
			a.setBio(rs.getString("bio"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
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
