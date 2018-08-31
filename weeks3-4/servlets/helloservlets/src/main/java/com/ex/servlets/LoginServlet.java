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
import com.ex.service.DummyUserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * Request Dispatcher, is used for forwarding
		 */
		
		req.getRequestDispatcher("login.html").forward(req,resp);
	}
	
	static DummyUserService uService=new DummyUserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get login info from form
		
		String name=req.getParameter("username");
		String pass=req.getParameter("password");
		
		System.out.println("Logging in user "+ name+":"+pass);
		
		User u=uService.getByUsername(name);
		PrintWriter out= resp.getWriter();
		if(u==null) {
			//redirect sends me to another servlet
		//	out.println("Invalid login");
			resp.sendRedirect("login");
		}
		else if(!u.getPassword().equals(pass)) {
			out.println("Invalid Password");
			
		} 
		else {
			//getSession returns current session or crettes one if nonexistent
			
			HttpSession session=req.getSession();
			session.setAttribute("user", u);
			out.println("Welcome, "+name);
			resp.sendRedirect("home");
		}
		
		
	}
	

}
