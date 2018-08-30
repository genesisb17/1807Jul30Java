package com.rev.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.exceptions.IncorrectLoginCredentialsException;
import com.rev.exceptions.NotYetImplementedException;
import com.rev.exceptions.UserNotFoundException;
import com.rev.pojos.User;
import com.rev.services.ReimbService;
import com.rev.services.UserService;

public class MasterDispatcher{
	
	private UserService uservice = new UserService();
	private ReimbService reimbService = new ReimbService();
	
	private static MasterDispatcher masterDispatcher = new MasterDispatcher();

	private MasterDispatcher() {};
	
	public static User routeTraffic(HttpServletRequest request, HttpServletResponse response) throws NotYetImplementedException {
		System.out.println(request.getRequestURI().toString());
		switch(request.getRequestURI()) {
		case "/ers/login":
			return masterDispatcher.login(request, response);
		case "/ers/createAccount":
			return masterDispatcher.createAccount(request, response);
		default:
			System.out.println("Not yet implemented");
			throw new NotYetImplementedException();
		}
	}

	private User login(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		
		try {
			user = mapper.readValue(request.getReader(), User.class);
			System.out.println(((User) user).toString());
			User authorized = uservice.login(user.getUsername(),user.getPassword());
			return authorized;
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (IncorrectLoginCredentialsException ilce) {
			ilce.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	private User createAccount(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		User authorized = null;
		try {
			user = mapper.readValue(request.getReader(), User.class);
			System.out.print(user.toString());
			authorized = uservice.login(user.getUsername(), user.getPassword());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (UserNotFoundException e){
			//This is what we want!
//			return uservice.createAccount(user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname(),user.getEmail(),user.getCompanyRole());			
		} catch (IncorrectLoginCredentialsException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}


