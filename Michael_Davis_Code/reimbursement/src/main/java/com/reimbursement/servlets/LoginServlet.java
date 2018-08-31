package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursement.pojos.User;
import com.reimbursement.service.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//REQUEST DISPATCHER! Used for forwarding
		req.getRequestDispatcher("partials/loginView.html").forward(req, resp);
		
	}
	
	static UserService uService=new UserService();
	//static DummyUserService uService = new DummyUserService();
	
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException {
		//functionality to get info from login form 
		
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		System.out.println("LOGGING IN USER " + name  + ":" + pass);
		
		System.out.println(uService.getByUsername(name));
		User u = uService.getByUsername(name);
		
		PrintWriter out = resp.getWriter();
		System.out.println("Printing out user returned :"+u);
		if(u == null) {
			//System.out.println("inside null uname block");
			out.write("This user does not Exist");
			resp.sendRedirect("login");
			
			
		}
		else if(!u.getUserpassword().equals(pass)) {
			resp.sendRedirect("login");
		
		}
		else {
			//valid login getSession() - returns 
			//current session or creates new one if none exists
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			System.out.println(session.getAttribute("user"));
			
			//System.out.println(session.getAttribute("user").getClass().getName().toString());
			//out.println("Welcome, " + name + "!");
			resp.sendRedirect("home");
		}
	
	
	}
	

}