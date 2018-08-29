package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.service.UserService;


public class MasterDispatcher {
	private MasterDispatcher() {
		
	}
	
	public static Object process(HttpServletRequest req, HttpServletResponse resp) {
		switch(req.getRequestURI()) {
			
			case "/ers-jdbc/login.view" :
				return "loginView";
			case "/ers-jdbc/verify.view":
				return UserService.login(req, resp);
			case "/ers-jdbc/account.view":
				return "accountView";
			case "/ers-jdbc/menu.view":
				return "menuView";
			case "/ers-jdbc/create.view":
				return "createView";
			default:
				return "errorView";
		}
		
	}
}