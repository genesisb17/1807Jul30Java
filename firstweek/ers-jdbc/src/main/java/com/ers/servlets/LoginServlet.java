package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getRequestDispatcher("index.html").forward(req, resp);
//	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override 	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resource = "partials/" + process(req, resp) + ".html";	
		resp.addHeader("Access-Control-Allow-Origin", "*");
	
		req.getRequestDispatcher(resource).forward(req, resp);
	}
	
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		
		switch(req.getRequestURI()) {
		case "/ers-jdbc/login.view":
			return "loginView";
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
