package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojos.User;
import com.rev.service.DummyUserService;

public class LoginServlet extends HttpServlet {

	static DummyUserService uService = new DummyUserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// REQUEST DISPATCHER? Used for forwarding
		req.getRequestDispatcher("login.html").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Functionality to get info from webpage
		String name = req.getParameter("username");
		String pass = req.getParameter("password");

		System.out.println("Logging in " + name + ":" + pass);

		User u = uService.getByUsername(name);

		PrintWriter out = resp.getWriter();
		if (u == null) {
			out.println("Sorry, invalid username");
//			resp.sendRedirect("login");
		} else if (!u.getPassword().equals(pass)) {
			out.println("Sorry, invalid password");
//			resp.sendRedirect("login");
		} else {
			// Valid login!
			HttpSession session = req.getSession(); //Returns current session or creates a new one if none exists
			session.setAttribute("user", u);
			out.println("Welcome, " + name + "!");
		}
	}
	


}
