package com.rev.tests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.rev.dao.UserDAO;
import com.rev.pojos.User;
import com.rev.utils.ConnectionFactory;

import junit.framework.TestCase;

public class UserDAOTest extends TestCase {
	
	private UserDAO udao = new UserDAO();

	protected void setUp() throws Exception {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "{call quick_populate_ers_users}";

			CallableStatement cs = conn.prepareCall(query);
			cs.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void tearDown() throws Exception {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "TRUNCATE TABLE ers_user";

			Statement s = conn.createStatement();
			s.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void testGetAll() {
		List<User> users = udao.getAll();
		assertEquals(5, users.size());
	}

	public void testGetOne() {
		User user = udao.getOne(1L);
		assertEquals(1L,user.getUserID());
		assertEquals("rayd123",user.getUsername());
		assertEquals("password",user.getPassword());
		assertEquals("Raymond",user.getFirstname());
		assertEquals("Duncan",user.getLastname());
		assertEquals("raydunc@gmail.com",user.getEmail());
//		assertEquals(1,user.getCompanyRole());
	}

	public void testSave() {
		User user = new User();
		user.setUsername("mariogtluigi");
		user.setPassword("1upMaster");
		user.setFirstname("Mario");
		user.setLastname("Mario");
		user.setEmail("notasgoodastoad@toad.kingdom");
//		user.setCompanyRole("Inspiration");
		
		List<User> users = udao.getAll();
		assertEquals(6,users.size());
		
		User user6 = users.get(6);
		assertEquals(user.getUserID(),user6.getUserID());
		assertEquals("rayd123",user.getUsername(),user6.getUsername());
		assertEquals("password",user.getPassword(),user6.getPassword());
		assertEquals("Raymond",user.getFirstname(),user6.getFirstname());
		assertEquals("Duncan",user.getLastname(),user6.getLastname());
		assertEquals("raydunc@gmail.com",user.getEmail(),user6.getEmail());
//		assertEquals(1,user.getCompanyRole(),user.getCompanyRole);
		
	}

}
