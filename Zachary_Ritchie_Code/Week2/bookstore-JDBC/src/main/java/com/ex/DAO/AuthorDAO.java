package com.ex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.pojo.Author;
import com.ex.util.ConnectionFactory;

public class AuthorDAO implements DAO<Author, Integer>
{
	
	@Override
	public List<Author> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author save(Author obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			// connections commit after transaction is complete set auto to false to do some sort of validation
			conn.setAutoCommit(false);
			
			String sql = "insert into author(firstname, lastname, bio) values(?, ?, ?)";
			
			//code to get auto generated key
			String[] keys = {"Author_Id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(2, obj.getFirstname());
			ps.setString(3, obj.getLastname());
			ps.setString(4, obj.getBio());
			
			int numRowsAffected = ps.executeUpdate();
			if (numRowsAffected > 0 )
			{
				ResultSet pk = ps.getGeneratedKeys();
				
				while(pk.next())
				{
					obj.setFirstname(pk.getString(2));
					obj.setLastname(pk.getString(3));
				}
			}
			conn.commit();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return obj;
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
