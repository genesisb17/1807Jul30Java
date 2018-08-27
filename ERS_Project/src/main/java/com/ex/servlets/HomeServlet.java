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

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN DOGET FOR HOMESERVLET");
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		if(user == null) {
			//invalid session. take to login
			response.sendRedirect("login");
		}
		else {
			request.getRequestDispatcher("welcome.html").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String answerForHistory = request.getParameter("history");
		String answerForSubmit = request.getParameter("newReimbursement");
		
		if (answerForHistory != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("history.html");
			requestDispatcher.forward(request, response);
		}
		else if (answerForSubmit != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("submit.html");
			requestDispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("login.html");
		}
		
	}
}
