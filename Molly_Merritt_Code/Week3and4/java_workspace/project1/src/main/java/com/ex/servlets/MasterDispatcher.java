package com.ex.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.service.UserService;

public class MasterDispatcher {
	
	private MasterDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse resp) {
		switch(request.getRequestURI()) {
		case "/project1/login.ng":
			System.out.println("in master dispatcher");
			return UserService.login(request, resp);
		default:
			return "not yet implemented";
		}
	}

}
