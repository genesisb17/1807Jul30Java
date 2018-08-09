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

public class GenreDAO {


	public static void main(String[] args) {
		//LETS SEE THIS WORK!
		/*	List<Genre> genres = findAll();
		for(Genre g : genres) {
			System.out.println(g);
		} */

		//System.out.println(findOne(5));
		
		Genre temp = new Genre();
		temp.setName("Classics");
		save(temp);
	}

	/*
	 * STATEMENT
	 * - takes an SQL statement as a string, executes it, 
	 * and returns the result
	 * - allows SQL injection so is bad to use. if you 
	 * MUST, only use it for queries with no variables
	 * 
	 */
	public static List<Genre> findAll(){
		List<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String query = "select * from genre";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				//iterate through each row of result set
				Genre temp = new Genre();
				temp.setId(rs.getInt(1)); // can access cols of RS by either col name or id
				String name = rs.getString(2);
				temp.setName(name);
				genres.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genres;
	}
	/*
	 * PREPARED STATEMENT
	 * - executes a pre-compiled SQL statement 
	 * - efficient for statements that will execute multiple times
	 */
	public static Genre findOne(int id){
		Genre g = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from genre where genre_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			g = new Genre();
			g.setId(info.getInt(1));
			g.setName(info.getString(2));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
	
	public static Genre save(Genre g) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			/*
			 * connections automatically commit after tx is 
			 * complete/right before connection closes
			 * set to false to do some sort of validation
			 * before committing
			 */
			conn.setAutoCommit(false);
			String sql = "insert into genre(name) values(?)";
			
			//code to get back auto-generated PK (other columns can be auto generated too!)
			String[] keys = {"Genre_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1,g.getName());
			
			//UPDATES return num rows added/updated/deleted
			//QUERIES return result sets
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected>0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.toString());
					g.setId(pk.getInt(1));
				}
				
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return g;
	}

}
