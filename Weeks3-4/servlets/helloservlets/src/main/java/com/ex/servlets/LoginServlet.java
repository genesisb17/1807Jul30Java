package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.User;
import com.ex.service.DummyUserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
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
			out.println("Sorry, invalid username");
		}
		else if(!u.getPassword().equals(pass)) {
			out.println("Sorry, invalid passsword");
		}
		else {
			//valid login 
			out.println("Welcome, " + name + "!");
		}
	
	
	}
	

}
