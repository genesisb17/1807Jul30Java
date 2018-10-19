package com.rev.services;

import com.rev.exceptions.IncorrectLoginCredentialsException;
import com.rev.exceptions.IncorrectPasswordException;
import com.rev.pojos.User;
import com.rev.utils.UserCompanyRole;

import junit.framework.TestCase;

public class UserServiceTest extends TestCase {

	UserService uService = new UserService();

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testLogin() throws IncorrectLoginCredentialsException {
		User user = null;
		user = uService.login("rayd123", "password");

		assertEquals("rayd123", user.getUsername());
		assertEquals("password", user.getPassword());
		assertEquals("Raymond", user.getFirstname());
		assertEquals("Duncan", user.getLastname());
		assertEquals("raydunc@gmail.com", user.getEmail());
		assertEquals(UserCompanyRole.fromInt(1), user.getCompanyRole());
		assertEquals(0L, (long) user.getCreator());
	}

	public void testCreateAccount() {
		User creator = new User();
		creator.setUserID(0L);
		String companyRole = UserCompanyRole.fromInt(1);
		User newUser = uService.createAccount("raydtoo", "password", "Raymond", "Duncan", "raydunc15@gmail.com",
				companyRole, creator);

		assertEquals("raydtoo", newUser.getUsername());
		assertEquals("password", newUser.getPassword());
		assertEquals("Raymond", newUser.getFirstname());
		assertEquals("Duncan", newUser.getLastname());
		assertEquals("raydunc15@gmail.com", newUser.getEmail());
		assertEquals(companyRole, newUser.getCompanyRole());
		assertEquals(creator.getUserID(), newUser.getCreator());

	}

	public void testChangePassword() throws IncorrectLoginCredentialsException, IncorrectPasswordException {
		User user = uService.login("mrt123", "pitydafoo");
		User newPwd = uService.changePassword(user, "pitydafoo", "pitydafooo");
		assertEquals(user.getUsername(),newPwd.getUsername());
		assertEquals("pitydafooo",newPwd.getPassword());
		assertEquals(user.getFirstname(),newPwd.getFirstname());
		assertEquals(user.getLastname(),newPwd.getLastname());
		assertEquals(user.getEmail(),newPwd.getEmail());
		assertEquals(user.getCompanyRole(),newPwd.getCompanyRole());
		assertEquals(user.getCreator(),newPwd.getCreator());
	}

	public void testChangeEmail() throws IncorrectLoginCredentialsException, IncorrectPasswordException {
		User user = uService.login("notoriousb", "bigpoppa");
		User newEmail = uService.changeEmail(user, user.getPassword(), "chriswallace@gmail.com");
		assertEquals(user.getUsername(),newEmail.getUsername());
		assertEquals(user.getPassword(),newEmail.getPassword());
		assertEquals(user.getFirstname(),newEmail.getFirstname());
		assertEquals(user.getLastname(),newEmail.getLastname());
		assertEquals("chriswallace@gmail.com",newEmail.getEmail());
		assertEquals(user.getCompanyRole(),newEmail.getCompanyRole());
		assertEquals(user.getCreator(),newEmail.getCreator());
	}

}
