package com.reimbursement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoadViewsServlet extends HttpServlet{
	private static Logger log = 
			Logger.getLogger(LoadViewsServlet.class);
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		log.trace("Initializing LoadViewsServlet");
	}
	
	@Override 	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IN LOAD VIEW SERVLET");
		String resource = "partials/" + process(req, resp) + ".html";	
		//resp.addHeader("Access-Control-Allow-Origin", "*");
	System.out.println("Forwarding :" + resource);

		req.getRequestDispatcher(resource).forward(req, resp);

	}
	
	
	static String process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println(req.getRequestURI());
		log.info("REQUEST SENT TO: " + req.getRequestURI());
		log.info("PATH: " + req.getPathInfo());
		switch(req.getRequestURI()) {
		case "/reimbursement/home.view":
			System.out.println("printing from homeviewSwitchCase");
			return "homeView";
		case "/reimbursement/users.view":
			return "usersView";
		case "/reimbursement/login.view":
			return "loginView";
		case "/reimbursement/reimb.view":
		
			return "reimbursementView";
		case "/reimbursement/addReimb.view":
			return "addreimbursementView";
		case "/reimbursement/updateReimb.view":
			return "updateReimbursement";
		
		default:
			System.out.println("NO URI MATCH");
			return "errorView";
		}
		
	}
}