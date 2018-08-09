package com.iantimothyjohnson.notes.week2.bookstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iantimothyjohnson.notes.week2.bookstore.pojos.Genre;
import com.iantimothyjohnson.notes.week2.bookstore.util.ConnectionFactory;

public class GenreDAO {
	public static List<Genre> findAll() {
		List<Genre> genres = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// We don't include the semicolon in our query.
			String query = "SELECT genre_id, name FROM genre";
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

	public static Genre findOne(int id) {
		Genre g = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// We don't include the semicolon in our query.
			String query = "SELECT genre_id, name FROM genre";
			// Statement interface:
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				g = new Genre(rs.getInt("genre_id"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return g;
	}

	// Just for testing purposes.
	public static void main(String[] args) {
		List<Genre> genres = findAll();
		for (Genre g : genres) {
			System.out.println(g);
		}
		System.out.println(findOne(0));
		BookDAO bdao = new BookDAO();
		bdao.findAll().forEach(System.out::println);
	}
}
