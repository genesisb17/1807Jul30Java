package com.iantimothyjohnson.notes.week2.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iantimothyjohnson.notes.week2.bookstore.pojos.Genre;
import com.iantimothyjohnson.notes.week2.bookstore.util.ConnectionFactory;

public class GenreDAO implements DAO<Genre, Integer> {
	@Override
	public List<Genre> findAll() {
		List<Genre> genres = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// We don't include the semicolon in our query.
			String query = "SELECT genre_id, name FROM genre ORDER BY name ASC";
			// Statement interface:
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				// Iterate through each row of result set.
				Genre tmp = new Genre();
				// Indexes in ResultSets are 1-based.
				tmp.setId(rs.getInt(1));
				// We can also refer to columns by the column label.
				tmp.setName(rs.getString("name"));

				genres.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return genres;
	}

	@Override
	public Genre findOne(Integer id) {
		Genre g = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// We don't include the semicolon in our query.
			String query = "SELECT genre_id, name FROM genre WHERE genre_id = ?";
			// Statement interface:
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			rs.next();
			g = new Genre(rs.getInt("genre_id"), rs.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return g;
	}

	@Override
	public Genre save(Genre g) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// We don't want our connection to auto-commit after TX is complete;
			// instead; we'd like to validate before committing.
			conn.setAutoCommit(false);
			final String sql = "INSERT INTO genre(name) VALUES(?)";
			// Code to get back auto-generated PK (other columns can be
			// auto-generated too).
			String[] keys = { "genre_id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, g.getName());
			int numRowsAffected = ps.executeUpdate();
			if (numRowsAffected > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					g.setId(pk.getInt(1));
				}
				// Make sure to commit our changes so they will be saved to the
				// DB.
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return g;
	}

	@Override
	public Genre update(Genre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Genre obj) {
		// TODO Auto-generated method stub

	}
}
