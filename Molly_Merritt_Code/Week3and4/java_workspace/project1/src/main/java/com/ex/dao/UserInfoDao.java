package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.pojos.User;
import com.ex.pojos.UserInformation;
import com.ex.util.ConnectionFactory;

public class UserInfoDao implements Dao<UserInformation, Integer> {

	public UserInformation findOne(String username) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM example_user_information "
					+ "WHERE username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new UserInformation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException sql) {
			System.err.println("SQL State: " +sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		UserDao uDao = new UserDao();
//		UserInformation u = new UserInformation("iamamanager2", "thisismypassword", "Michael", "Scott", "email2@email.com", 2);
//		uDao.update(u);
////		System.out.println(uDao.isUnique(u));
//		uDao.save(u);
//	}

	@Override
	public UserInformation findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInformation save(UserInformation obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInformation update(UserInformation obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnique(UserInformation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserInformation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public List<User> findAll() {
//		List<User> users = new ArrayList<User>();
//		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			String sql = "{call get_all_users(?)}";	// must call inside curly braces
//			
//			CallableStatement cs = conn.prepareCall(sql);
//			cs.registerOutParameter(1, OracleTypes.CURSOR);
//			cs.execute();
//			
//			ResultSet rs = (ResultSet) cs.getObject(1);
//			while(rs.next()) {
//				User temp = new User();
//				temp.setUsername(rs.getString("ERS_USERNAME"));
//				temp.setPassword(rs.getString("ERS_PASSWORD"));
//				temp.setFirstname(rs.getString("USER_FIRST_NAME"));
//				temp.setLastname(rs.getString("USER_LAST_NAME"));
//				temp.setEmail(rs.getString("USER_EMAIL"));
//				temp.setUserRoleId(rs.getInt("USER_ROLE_ID"));
//				users.add(temp);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return users;
//	}
//
//	public User findOne(Integer id) {
//		User u = new User();
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//			String sql = "select * from ERS_USERS where ERS_USERS_ID = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			ResultSet info = ps.executeQuery();
//			
//			info.next();
//			u.setUsername(info.getString(1));
//			u.setPassword(info.getString(2));
//			u.setFirstname(info.getString(3));
//			u.setLastname(info.getString(4));
//			u.setEmail(info.getString(5));
//			u.setUserRoleId(info.getInt(6));
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return u;
//	}
//
//	public User save(User obj) {
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			conn.setAutoCommit(false);
//			String query = "INSERT INTO ers_users(ers_username, ers_password, user_first_name, "
//					+ "user_last_name, user_email, user_role_id) VALUES(?,?,?,?,?,?)";
//			
//			String[] keys = new String[1];
//			keys[0] = "ERS_USERS_ID";	// column name where keys are
//			
//			PreparedStatement ps = conn.prepareStatement(query, keys);
//			
//			ps.setString(1, obj.getUsername());
//			ps.setString(2,  obj.getPassword());
//			ps.setString(3, obj.getFirstname());
//			ps.setString(4, obj.getLastname());
//			ps.setString(5, obj.getEmail());
//			ps.setInt(6, obj.getUserRoleId());
//			
//			int rows = ps.executeUpdate();
//			
//			if(rows != 0) {
//				ResultSet pk = ps.getGeneratedKeys();	// generated keys
//				while(pk.next()) {
//					obj.setId(pk.getInt(1));
//				}
//				conn.commit();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return obj;
//	}
//
//	public User update(User obj) {
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			String stmt = "update ERS_USERS set ERS_USERNAME = ?, ERS_PASSWORD = ?, "
//					+ "USER_FIRST_NAME = ?, USER_LAST_NAME = ?, USER_EMAIL = ?, "
//					+ "USER_ROLE_ID = ? where ERS_USERS_ID = ?";
//			
//			PreparedStatement ps = conn.prepareStatement(stmt);
//			
//			ps.setString(1, obj.getUsername());
//			ps.setString(2, obj.getPassword());
//			ps.setString(3, obj.getFirstname());
//			ps.setString(4, obj.getLastname());
//			ps.setString(5, obj.getEmail());
//			ps.setInt(6, obj.getUserRoleId());
//			ps.setInt(7, obj.getId());
//			
//			ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public boolean isUnique(User obj) {	// username & email must be unique
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			String query = "select * from ERS_USERS where ERS_USERNAME = ? or "
//					+ "USER_EMAIL = ?";
//			
//			String[] keys = new String[1];
//			keys[0] = "ERS_USERS_ID";	// column name where keys are
//			
//			PreparedStatement ps = conn.prepareStatement(query, keys);
//			
//			ps.setString(1, obj.getUsername());
//			ps.setString(2, obj.getEmail());
//			
//			ResultSet info = ps.executeQuery();
//			
//			if(info.next()) {
//				return false;
//			} else {
//				return true;
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//	
//	public static void main(String[] args) {
//		UserDao uDao = new UserDao();
//		User u = new User(31, "iamamanager2", "thisismypassword", "Michael", "Scott",
//				"email2@email.com", 2);
////		uDao.update(u);
////		System.out.println(uDao.isUnique(u));
////		uDao.save(u);
//	}

}
