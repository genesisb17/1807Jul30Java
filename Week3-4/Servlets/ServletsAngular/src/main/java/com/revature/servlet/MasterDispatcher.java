package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.UserService;

public class MasterDispatcher {
	
	private MasterDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/ServletsAngular/login.ng":
			return UserService.login(request, response);
		default:
			return "not yet implemented";
		}
	}
}
