package com.rev.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.exceptions.NotYetImplementedException;
import com.rev.pojos.User;
import com.rev.services.UserService;

public class MasterDispatcher{

	private MasterDispatcher() {};
	
	public static User routeTraffic(HttpServletRequest request, HttpServletResponse response) throws NotYetImplementedException {
		User user = null;
		switch(request.getRequestURI()) {
		case "/ers/login.ng":
			UserService uService = new UserService();
			return uService.login(request, response);
		default:
			throw new NotYetImplementedException();
		}
	}

}
