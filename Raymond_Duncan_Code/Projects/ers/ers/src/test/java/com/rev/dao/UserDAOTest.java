package com.rev.dao;

import java.util.List;

import com.rev.dao.UserDAO;
import com.rev.pojos.User;
import com.rev.utils.UserCompanyRole;

import junit.framework.TestCase;

public class UserDAOTest extends TestCase {
	
	private UserDAO udao = new UserDAO();

	public void testGetAll() {
		List<User> users = udao.getAll();
		assertEquals(5, users.size());
	}

	public void testGetOne() {
		User user = udao.getOne(1L);
		assertEquals("rayd123",user.getUsername());
		assertEquals("Raymond",user.getFirstname());
		assertEquals("Duncan",user.getLastname());
		assertEquals("raydunc@gmail.com",user.getEmail());
		assertEquals(UserCompanyRole.fromInt(1),user.getCompanyRole());
	}
	
	public void testSave() {
		User user = udao.getOne(1L);
		user.setPassword("newPassword");
		user.setEmail("newEmail@gmail.com");
		User userRet = udao.save(user);
		assertEquals(user,userRet);
		
		user = udao.getOne(1L);
		assertEquals("newEmail@gmail.com",user.getEmail());
	}

	public void testSaveNew() {
		User user = new User();
		user.setUsername("mariogtluigi");
		user.setPassword("1upMaster");
		user.setFirstname("Mario");
		user.setLastname("Mario");
		user.setEmail("notasgoodastoad@toad.kingdom");
		user.setCompanyRole(UserCompanyRole.fromInt(1));
		User user1 = udao.saveNew(user);
		assertEquals(user,user1);
		
		List<User> users = udao.getAll();
		assertEquals(6,users.size());
		
		User user6 = users.get(5);
//		assertEquals(user.getUserID(),user6.getUserID());
		assertEquals(user.getUsername(),user6.getUsername());
		assertEquals(user.getFirstname(),user6.getFirstname());
		assertEquals(user.getLastname(),user6.getLastname());
		assertEquals(user.getEmail(),user6.getEmail());
		assertEquals(user.getCompanyRole(),user.getCompanyRole());
		
	}

}
