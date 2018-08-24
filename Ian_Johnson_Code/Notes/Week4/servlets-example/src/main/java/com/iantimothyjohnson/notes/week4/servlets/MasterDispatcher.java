package com.iantimothyjohnson.notes.week4.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iantimothyjohnson.notes.week4.service.UserService;

public class MasterDispatcher {
	private MasterDispatcher() {
	}
	
	public static Object process(HttpServletRequest req, HttpServletResponse resp) {
		switch (req.getRequestURI()) {
		case "/servlets-example/login.ng":
			return UserService.login(req, resp);
		default:
			return "not yet implemented";
		}
	}
}
