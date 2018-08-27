package com.rev.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.UserDAO;
import com.rev.exceptions.IncorrectLoginCredentialsException;
import com.rev.exceptions.IncorrectPasswordException;
import com.rev.pojos.User;

public class UserService {
	
	private UserDAO udao = new UserDAO();
	
	public User login(HttpServletRequest request, HttpServletResponse response) throws IncorrectLoginCredentialsException {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		
		try {
			user = mapper.readValue(request.getReader(), User.class);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		User authorized = login(user.getUsername(),user.getPassword());
		return null;
		
	}
	
	private User login(String username, String password) throws IncorrectLoginCredentialsException{
		User user = validateCredentials(username,password);
		return user;
	}
	
	public User createAccount(String username, String password, String firstname, String lastname, String email, String companyRole, User creator) {
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setFirstname(firstname);
		newUser.setLastname(lastname);
		newUser.setEmail(email);
		newUser.setCompanyRole(companyRole);
		newUser.setCreator(creator.getUserID());
		
		return udao.saveNew(newUser);
	}
	
	public User changePassword(User user, String oldPassword, String newPassword) throws IncorrectPasswordException{
		try {
			validateCredentials(user.getUsername(), oldPassword);
			user.setPassword(newPassword);
			user = udao.save(user);
		} catch (IncorrectLoginCredentialsException e) {
			throw new IncorrectPasswordException();
		}
		return user;
	}
	
	public User changeEmail(User user, String password, String newEmail) throws IncorrectPasswordException{
		try {
			validateCredentials(user.getUsername(), password);
			user.setEmail(newEmail);
			user = udao.save(user);
		} catch (IncorrectLoginCredentialsException e) {
			throw new IncorrectPasswordException();
		}
		return user;
	}
	
	private User validateCredentials(String username, String password) throws IncorrectLoginCredentialsException{
		User user = udao.getOne(username);
		if(user == null) {
			throw new IncorrectLoginCredentialsException();
		} else if(!user.getPassword().equals(password)) {
			throw new IncorrectLoginCredentialsException();
		}
		return user;		
	}

}
