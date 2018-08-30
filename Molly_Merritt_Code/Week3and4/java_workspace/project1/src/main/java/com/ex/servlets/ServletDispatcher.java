package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.User;
import com.ex.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ServletDispatcher
 */
//@WebServlet("/login")
public class ServletDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UserService uService = new UserService();
       
    public ServletDispatcher() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("in doGet method");
		response.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().write(mapper.writeValueAsString(MasterDispatcher.process(request, response)));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);
		
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		
		System.out.println("LOGGING IN USER " + name + ":" + pass);
		
		User u = uService.getUser(name);
		
		PrintWriter out = response.getWriter();
		if(u == null) {
//			out.println("Sorry, invalid username");
			response.sendRedirect("login");
		} else if(!u.getPassword().equals(pass)) {
			out.println("Sorry, invalid password");
		} else { // valid login getSession() - returns current session or creates new one if none exist
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
//			out.println("Welcome, " + name + "!");
			response.sendRedirect("home");
		
		}
	}

}
