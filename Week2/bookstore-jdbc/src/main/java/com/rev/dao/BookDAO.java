package com.rev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Book;
import com.rev.pojos.Genre;
import com.rev.util.ConnectionFactory;

public class BookDAO {

	//don't put main method in dao class. best practice
		public static void main(String[] args) {
			List<Book> books = findAll();
			
			for(Book b: books) {
				System.out.println(b);
			}
		}

		public static List<Book> findAll() {
			//gives this method the ability to make this any type of list. you don't need to worry of the type of 
			//list when you call this method.
			List<Book> books = new ArrayList<Book>();
			try (Connection conn = ConnectionFactory
					.getInstance().getConnection()){ //singleton so you don't use 'new'
				String query = "select * from book";
				//STATEMENT INTERFACE
				//Connection is really important interface. you can only instantiate things that implement connection
				Statement statement = conn.createStatement();
				
				//now get result set. (any executeUpdate is going to return number of rows affected)
				ResultSet rs = statement.executeQuery(query);
				
				//iterate through result set. each row
				while(rs.next()) {
					Book temp = new Book();
					temp.setId(rs.getInt(1));
					temp.setIsbn(rs.getString(2));
					temp.setTitle(rs.getString(3));
					temp.setPrice(rs.getInt(4));
					temp.setGenreId(rs.getInt(5));
													
					books.add(temp);
				}
				

			} catch(SQLException e) {
				e.printStackTrace();
			}
			return books;
		}	
	

}
