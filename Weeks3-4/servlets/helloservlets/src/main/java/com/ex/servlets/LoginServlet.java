package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException {
		//functionality to get info from login form 
		
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		System.out.println("LOGGING IN USER " + name  + ":" + pass);
	}
	

}
