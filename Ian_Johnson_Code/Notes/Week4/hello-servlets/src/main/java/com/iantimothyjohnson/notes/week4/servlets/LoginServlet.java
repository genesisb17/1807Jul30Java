package com.iantimothyjohnson.notes.week4.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iantimothyjohnson.notes.week4.pojos.User;
import com.iantimothyjohnson.notes.week4.service.DummyUserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static DummyUserService userService = new DummyUserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// The RequestDispatcher allows us to forward a request for one endpoint
		// to another endpoint.
		req.getRequestDispatcher("login.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Functionality to get info from login form.
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userService.getByUsername(username);

		if (user == null || !user.getPassword().equals(password)) {
			resp.sendRedirect("login");
			return;
		}
		// req.getSession returns the current session or creates a new one if
		// none exists.
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		resp.sendRedirect("home");
	}
}
