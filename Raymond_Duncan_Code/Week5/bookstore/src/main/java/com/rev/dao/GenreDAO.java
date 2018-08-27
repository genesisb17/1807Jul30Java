package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Genre;
import com.rev.util.ConnectionFactory;

public class GenreDAO implements DAO<Genre, Integer> {

//	public static void main(String[] args) {
//		GenreDAO gdao = new GenreDAO();
//		List<Genre> genres = gdao.findAll();
//		for (Genre g : genres) {
//			System.out.println(g.toString());
//		}
//
////		System.out.println("Showing SQL Injection");
////		String sqlInjection = "1";
////		gdao.findOne(sqlInjection);
//
//		System.out.println(gdao.findOne(5).toString());
//		
//		gdao.save(new Genre(1,"Classics"));
//	}

	
	
	/*
	 * STATEMENT - takes an SQL statement as a string, executes it, and returns the
	 * result - allows SQL injection so is bad to use. if you MUST, only use it for
	 * queries with no variables.
	 */
	
	@Override
	public List<Genre> findAll() {
		List<Genre> genres = new ArrayList<Genre>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from genre";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				// iterate through each row of result set
				Genre temp = new Genre();
				temp.setId(rs.getInt(1)); // Alternatively, one could use the command temp.setId(rs.getInt("genre_id"));
				temp.setName(rs.getString(2)); // Alternatively, one could use the command
												// temp.setId(rs.getString("name"));
				// The two above statements work by accessing the nth column from the table
				// accessed. The alternate commands above use the column label!
				genres.add(temp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return genres;
	}

/////////////////////////// This is wrong! It introduces the possibility of sequel injection
//	public Genre findOne(String name){
//		Genre genre = null;
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//			String query = "select * from genre where genre_id = " + name;
//			
//			Statement statement = conn.createStatement();
//			ResultSet rs = statement.executeQuery(query);
//			while(rs.next()) {
//				genre = new Genre();
//				genre.setId(rs.getInt(1));		
//				genre.setName(rs.getString(2));		
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

	// Instead use a PREPARED STATEMENT
	/*
	 * PREPARED STATEMENT - executes a pre-compiled SQL statement - efficient for
	 * statements that will execute multiple times
	 */
	
	@Override
	public Genre findOne(Integer id) {
		Genre genre = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from genre where genre_id = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id); // Indicates that the first question mark in the above string should be replaced
								// with the variable 'id'

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				genre = new Genre();
				genre.setId(rs.getInt(1));
				genre.setName(rs.getString(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return genre;
	}

	public Genre save(Genre g) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false); // Connections automatically commit after it is complete (right before the
										// connection closes). Set to false to do some sort of validation

			String sql = "insert into genre(name) values(?)";
			//Code to get back auto-generated PK (Other columns can be auto-generated too)
			String[] primaryKeys = {"Genre_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql,primaryKeys);
			ps.setString(1,g.getName());
			//UPDATES return number of rows added/updated/deleted
			//queries/ return result sets
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					g.setId(pk.getInt(1));
				}
				conn.commit();	//Since autocommit is turned off, we must call this so the changes persist
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
