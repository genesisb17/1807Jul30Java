package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.util.ConnectionFactory;

import pojo.User;

public class UserDAO {

	//don't put main method in dao class. best practice
		public static void main(String[] args) {
			List<User> books = findAll();
			
			for(User b: books) {
				System.out.println(b);
			}
		}

		public static List<User> findAll() {
			//gives this method the ability to make this any type of list. you don't need to worry of the type of 
			//list when you call this method.
			List<User> books = new ArrayList<User>();
			try (Connection conn = ConnectionFactory
					.getInstance().getConnection()){ //singleton so you don't use 'new'
				String query = "select * from users";
				//STATEMENT INTERFACE
				//Connection is really important interface. you can only instantiate things that implement connection
				Statement statement = conn.createStatement();
				
				//now get result set. (any executeUpdate is going to return number of rows affected)
				ResultSet rs = statement.executeQuery(query);
				
				//iterate through result set. each row
				while(rs.next()) {
					User temp = new User();
					temp.setId(rs.getInt(1));
					//insert logic here to retrieve from 
													
					books.add(temp);
				}
				

			} catch(SQLException e) {
				e.printStackTrace();
			}
			return books;
		}	
	

}
