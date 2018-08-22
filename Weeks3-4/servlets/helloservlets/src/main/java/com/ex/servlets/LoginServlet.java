package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.User;
import com.ex.service.DummyUserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	/*
	 * INTERMEDIATE SERVLET TOPICS: redirects, forwards, sessions
	 * A Servletmay perform either a forward or a redirect operation at 
	 * the end of processing a request. It's important to understand the 
	 * difference between these two cases, in particular with respect 
	 * to browser reloads of web pages
	 * 
	 * FORWARD: a forward is performed internally by the servlet
	 * 	The browser is completely unaware that it has taken place, so 
	 * 		its original URL remains intact
	 * 	Any browser reload of the resulting page will simple repeat 
	 * 		the original request, with the original URL
	 * REDIRECT: a redirect is a two step process, where the web app
	 * 	instructs the browser to fetch a second URL, which differs from
	 * 	the original
	 * 	A browser reload of the second URL will not repeat the original 
	 * 		request, but will rather fetch the second URL
	 * 	Redirect is marginally slower than a forward, since it requires 
	 * 		two browser requests, not one
	 * 	Objects placed in the original request scope are not available 
	 * 		to the second request
	 * --> In general, a forward should be used if the operation can be 
	 * 		safely repeated upon a browser reload of the resulting web page; 
	 * 		otherwise, redirect must be used. Typically, if the operation 
	 * 		performs an edit on the datastore, then a redirect, not a forward, 
	 * 		is required. This is simply to avoid the possibility of inadvertently 
	 * 		duplicating an edit to the database.
	 * 
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//REQUEST DISPATCHER! Used for forwarding
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	
	static DummyUserService uService = new DummyUserService();
	
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException {
		//functionality to get info from login form 
		
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		System.out.println("LOGGING IN USER " + name  + ":" + pass);
		
		User u = uService.getByUsername(name);
		
		PrintWriter out = resp.getWriter();
		if(u == null) {
			//out.println("Sorry, invalid username");
			resp.sendRedirect("login");
		}
		else if(!u.getPassword().equals(pass)) {
			out.println("Sorry, invalid passsword");
		}
		else {
			//valid login getSession() - returns 
			//current session or creates new one if none exists
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			System.out.println(session.getId());
			//out.println("Welcome, " + name + "!");
			resp.sendRedirect("home");
		}
	
	
	}
	

}
