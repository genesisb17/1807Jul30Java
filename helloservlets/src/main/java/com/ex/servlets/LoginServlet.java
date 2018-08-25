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
import com.ex.services.DummyUserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//REQUEST DISPATCHER! Used for forwarding
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	static DummyUserService uService = new DummyUserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//functionality to get info from login form 
		
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		System.out.println("LOGGING IN USER " + name  + ":" + pass);
		
		User u = uService.getByUsername(name);
		
		PrintWriter out = resp.getWriter();
		if(u == null) {
			resp.sendRedirect("login");
		}
		else if(!u.getPassword().equals(pass)) {
			resp.sendRedirect("login");
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