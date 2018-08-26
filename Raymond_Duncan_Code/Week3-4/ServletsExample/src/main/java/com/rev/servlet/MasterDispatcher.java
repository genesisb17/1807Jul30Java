package com.rev.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.service.UserService;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	public static Object process(HttpServletRequest req, HttpServletResponse resp) {
		switch(req.getRequestURI()) {
		case "/ServletsExample/login.ng":
			return UserService.login(req,resp);
		default:
			return "not yet implemented";
		}
	}
}
