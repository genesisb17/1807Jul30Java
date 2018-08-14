package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Genre;
import com.ex.util.ConnectionFactory;

public class GenreDAO implements Dao<Genre, Integer> {
	
//	public static void main(String[] args) {
////		// LET'S SEE THIS WORK
////		List<Genre> genres = findAll();
////		for(Genre g : genres) {
////			System.out.println(g);	// automatically calls g.toString()
////		}
//		
////		String name = "'Sci-Fi'";
////		System.out.println(findOne(name));
//		
////		System.out.println(findOne(7));
//		Genre temp = new Genre();
//		temp.setName("Classics");
//		save(temp);
//	}
	
	/*
	 * STATEMENT
	 * 	- takes a SQL statement as a string, executes it, and returns the result
	 * 	- allows SQL injection so it is generally not recommended; use only with
	 * 	  queries and no variables
	 */
	
	public List<Genre> findAll() {
		List<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// Connection is an auto-closeable resource
			
			String query = "select * from genre order by name asc";
			
			// STATEMENT INTERFACE - allows you to run uncompiled SQL code in Java
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				// iterate through each row of result set
				Genre temp = new Genre();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));	// could also say getString("Name")
				// can access cols of RS by either col name or id
				genres.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genres;
	}
	
//	////////////////// WRONG
//	public static Genre findOne(String name) {
//		Genre g = new Genre();
//		List<Genre> genres = new ArrayList<Genre>();
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			// Connection is an auto-closeable resource
//			
//			String query = "select * from genre where name = " + name;
//			
//			// STATEMENT INTERFACE - allows you to run uncompiled SQL code in Java
//			Statement statement = conn.createStatement();
//			ResultSet rs = statement.executeQuery(query);
//			
//			while(rs.next()) {
//				// iterate through each row of result set
//				g.setId(rs.getInt(1));
//				String n = rs.getString(2);
//				g.setName(n);	// could also say getString("Name")
//				// can access cols of RS by either col name or id
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return g;
//	}
	
	/*
	 * PREPARED STATEMENT
	 * 	- executes a pre-compiled SQL statement
	 * 	- efficient for statements that will execute multiple times
	 */
	public Genre findOne(Integer id) {
		Genre g = null;
			// make sure something is null if you haven't gotten anything back
		List<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from genre where genre_id = ?";
				// question mark is a placeholder
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			info.next();
			g = new Genre();
			g.setId(info.getInt(1));
			g.setName(info.getString(2));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
	
	public Genre save(Genre g) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// connections automatically commit after tx is complete
			// set to false to do some sort of validation before committing
			conn.setAutoCommit(false);	// need to commit at some point
			
			String sql = "insert into genre(name) values (?)"; // create our query
			
			// code to get back auto-generated PK (other columns can be auto generated too!)
			String[] keys = {"Genre_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, g.getName());
			
			// UPDATES return num rows added/updated/deleted
			// QUERIES return result sets
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					g.setId(pk.getInt(1));
				}
			}
			
			conn.commit();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return g;
	}
	

	@Override
	public Genre update(Genre obj) {
		return null;
	}

	@Override
	public void delete(Genre obj) {
		
	}

}
