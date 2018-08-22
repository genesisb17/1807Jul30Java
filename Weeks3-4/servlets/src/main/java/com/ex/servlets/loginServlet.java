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
import com.ex.service.dumbyUserService;

@WebServlet("/login")
public class loginServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}
	
	static dumbyUserService uService = new dumbyUserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		System.out.println("Logging in user: " + name + " " + pass);
		
		User u = uService.getByUsername(name);
		
		PrintWriter out = resp.getWriter();
		
		if (u == null)
		{
			//System.out.println("Incorrect");
			//out.println("Sorry invalid username");
			resp.sendRedirect("login");
		}
		else if(!u.getPassword().equals(pass))
		{
			out.print("Sorry invalid password");
		}
		else
		{
			//valid login
			//System.out.println("Correct");
			HttpSession session = req.getSession();
            session.setAttribute("user", u);
            //out.println("Welcome, " + name + "!");
            resp.sendRedirect("home");
		}
	}
}
