package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.User;
import com.ex.services.UserServices;

public class LogInServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//REQUEST DISPATCHER! Used for forwarding
		System.out.println("Yo");
		request.getRequestDispatcher("/login.html").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Fam");
		response.setContentType("text/html");
		User user;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		user = UserServices.validation(username, password);
		
		if(user == null) {
			response.sendRedirect("login.html");
		}
		else {
			if (user.getRoleid() == 100) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				System.out.println(session.getId());
				response.sendRedirect("EmployeeHome.html");
			}
			else if (user.getRoleid() == 110) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				System.out.println(session.getId());
				response.sendRedirect("ManagerHome.html");
			}
		}
	}
}
