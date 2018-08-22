package com.ex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojo.Genre;
import com.ex.util.ConnectionFactory;

public class GenreDAO implements DAO<Genre, Integer>
{
	/*public static void main(String[] args)
	{
		/*List<Genre> genres = findAll();
		for(Genre g : genres)
		{
			System.out.println(g);
		}
		
		//System.out.println(findOne(1));
		
		Genre temp = new Genre();
		temp.setName("Classics");
		save(temp);
	}*/
	
	
	//////////STATEMENT/////////////
	@Override
	public List<Genre> getAll() {
		List<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "select * from genre order by name asc";
			
			// Statement interface
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next())
			{
				Genre temp = new Genre();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				genres.add(temp);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return genres;
	}
	
	
	////////////PREPARE STATEMENT/////////////////
	public Genre findOne(int id)
	{
		Genre g = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from genre where genre_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			info.next();
			g.setId(info.getInt(1));
			g.setName(info.getString(2));
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		} 
		return g;
	}
	
	@Override
	public Genre save(Genre g)
	{
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			// connections commit after transaction is complete set auto to false to do some sort of validation
			conn.setAutoCommit(false);
			
			String sql = "insert into genre(name) values(?)";
			
			//code to get auto generated key
			String[] keys = {"Genre_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, g.getName());
			
			int numRowsAffected = ps.executeUpdate();
			if (numRowsAffected > 0 )
			{
				ResultSet pk = ps.getGeneratedKeys();
				
				while(pk.next())
				{
					g.setId(pk.getInt(1));
				}
			}
			conn.commit();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return g;
	}



	@Override
	public Genre findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
