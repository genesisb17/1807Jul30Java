package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Reimbursement;
import com.ex.pojos.RequestForm;
import com.ex.pojos.UpdateForm;
import com.ex.pojos.User;
import com.ex.pojos.UserInformation;
import com.ex.util.ConnectionFactory;

public class UserDaoImp implements UserDao {

	private static UserDaoImp instance;
	
	// No argument constructor
	private UserDaoImp() {}
	
	// Checks if instance exists, creates one if not there
	public static UserDaoImp getInstance() {
		if (instance == null)
			instance = new UserDaoImp();
		return instance;
	}
	
	@Override
	public String getPasswordHash(User user) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareCall("SELECT get_user_hash(?,?) AS HASH FROM dual");
			ps.setString(++index, user.getUsername());
			ps.setString(++index, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString("HASH");
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.print("Error Code: " + sql.getErrorCode());	
		}
		return null;
	}
	
	@Override
	public UserInformation getUserInformation(String username) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT username, "
					+ "firstname, lastname, email, user_roles.U_ROLE "
					+ "FROM user_information inner join user_roles "
					+ "on user_information.ur_id=user_roles.ur_id "
					+ "WHERE USERNAME = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return new UserInformation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.print("Error Code: " + sql.getErrorCode());	
		}
		return null;
	}

	@Override
	public User getUser(String username) {
		int index = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ?");
			ps.setString(++index,  username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				System.out.println(rs);
				return new User(rs.getString(1), rs.getString(2));
			
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}

		return null;
	}

	@Override
	public List<Reimbursement> getEmpTables(String username) {
		List<Reimbursement> empList = new ArrayList<>();
		Reimbursement temp = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE USERNAME = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getString(3));
				temp.setResolved(rs.getString(4));
				temp.setDescription(rs.getString(5));
				temp.setReciept(rs.getBytes(6));
				temp.setAuthor(rs.getString(7));
				temp.setResolver(rs.getString(8));
				temp.setStatusid(rs.getInt(9));
				temp.setTypeid(rs.getInt(10));
				empList.add(temp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public List<Reimbursement> getAllTables() {
		List<Reimbursement> allList = new ArrayList<>();
		Reimbursement temp = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM REIMBURSEMENT";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getString(3));
				temp.setResolved(rs.getString(4));
				temp.setDescription(rs.getString(5));
				temp.setReciept(rs.getBytes(6));
				temp.setAuthor(rs.getString(7));
				temp.setResolver(rs.getString(8));
				temp.setStatusid(rs.getInt(9));
				temp.setTypeid(rs.getInt(10));
				allList.add(temp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allList;
	}

	@Override
	public int updateForm(UpdateForm updateForm) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE REIMBURSEMENT SET R_RESOLVED_TIME = SYSDATE, R_RESOLVER = ?, RS_ID = ? WHERE R_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "admin");
			ps.setInt(2, updateForm.getStatusid());
			ps.setInt(3, updateForm.getId());			
			int i = ps.executeUpdate();
			
			if (i == 1) {
				return 1;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int submitRequest(RequestForm requestForm) {
		int x = 0;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "INSERT INTO REIMBURSEMENT"
					+ " VALUES (REIMBURSEMENT_SEQ.nextval, ?, SYSDATE, null, ?, null, ?, null, 1, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, requestForm.getAmount());
			ps.setString(2, requestForm.getDescription());
			ps.setString(3, requestForm.getUsername());
			ps.setInt(4,  requestForm.getRequestType());
			System.out.println(requestForm.getAmount());
			System.out.println(requestForm.getDescription());
			System.out.println(requestForm.getUsername());
			System.out.println(requestForm.getRequestType());
			int i = ps.executeUpdate();
			
			// To show that the SQL statement executed correctly
			// 1 means that "one row was inserted"
			if (i == 1) {
				return i;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		// Returning false means something wrong happened
		// "no rows were inserted"
		return x;
	}
	
	
}

