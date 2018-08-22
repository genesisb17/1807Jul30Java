package com.ex.DAO;

import java.awt.print.Book;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojo.Books;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;


public class BookDAO implements DAO<Books, Integer>
{
	
	public static List<Books> findAll() {
		List<Books> books = new ArrayList<Books>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "select * from books";
			
			// Statement interface
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next())
			{
				Books temp = new Books();
				temp.setIsb(rs.getString(2));
				temp.setTitle(rs.getString(3));
				temp.setPrice(rs.getInt(4));
				books.add(temp);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return books;
	}

	@Override
	public List<Books> getAll() 
	{
		List<Books> books = new ArrayList<Books>();
		
		String sql = "{call get_all_books(?)";
		
		try(Connection c = ConnectionFactory.getInstance().getConnection())
		{
			
			CallableStatement cs = c.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet)cs.getObject(1);
			while(rs.next()) 
			{
				Books temp = new Books();
				temp.setBook_id(rs.getInt("Book_id"));
				temp.setIsb(rs.getString("isb"));
				temp.setTitle(rs.getString("title"));
				temp.setPrice(rs.getDouble("price"));
				temp.setGenre_id(rs.getInt("Genre_id"));
				books.add(temp);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	@Override
	public Books findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Books save(Books obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Books update(Books obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Books obj) {
		// TODO Auto-generated method stub
		
	}
	
	
}
	
