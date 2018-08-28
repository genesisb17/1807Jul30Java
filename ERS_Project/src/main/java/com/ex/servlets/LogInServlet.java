package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.User;
import com.ex.services.UserServices;

public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("LOGGING IN USER " + username + ":" + password);
		
		User user = UserServices.validation(username, password);
		
		System.out.println(request);

		if(user == null) {
			response.sendRedirect("login.html");
		}
		else {
			if (user.getRoleid() == 100) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				System.out.println(session.getId());
				response.sendRedirect("/ERS_Project/EmployeeWelcome");
			}
			else if (user.getRoleid() == 110) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				System.out.println(session.getId());
				response.sendRedirect("/ERS_Project/ManagerWelcome");
				// TODO: IMPLEMENT THIS
			}
		}
	}
}
