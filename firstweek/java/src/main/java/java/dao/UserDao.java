package java.dao;

import java.pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ConnectionFactory;
import java.util.List;

public class UserDao {
	
	//user login method checks username and password in the database
	public User findOne(String uname, String pwd) {
		User u = null;
		List<User> user = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql  = "SELECT * FROM USERS WHERE UPPER(USERNAME) = ? AND UPASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname.toUpperCase());
			ps.setString(2, pwd);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				u = new User();
				u.setUid(info.getInt(1));
				u.setUname(info.getString(2));
				u.setFirstname(info.getString(3));
				u.setLastname(info.getString(4));
				user.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			/* previously caught the exception here
			 * but this time i will try to pass it 
			 * up to the service layer 
			 */
			
		}	
		return u;
				
	}
	
	public static void main(String[] args) {
		UserDao u = new UserDao();
		u.findOne("admin","Admin");
	}
}
