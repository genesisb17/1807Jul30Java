package com.servlet.ex;

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

public class LoginServlet extends HttpServlet {
	//functionality to get info from login form
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("login.html").forward(req, resp); //doesn't handle the request, it sends it somewhere else
	}
	
	static DummyUserService uService = new DummyUserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String pw = req.getParameter("password");
		
		System.out.println("Logging in user " + name + " : " + pw);
		User u = uService.getByUsername(name);
		PrintWriter out = resp.getWriter();
		
		if(u == null) {
			//out.println("Sorry, invalid username");
			resp.sendRedirect("login");
		} else if(!u.getPassword().equals(pw)) {
			out.println("Sorry, invalid password");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			out.println("Welcome, " + name + "!");
			resp.sendRedirect("home");
		}
		
		
	}
}
