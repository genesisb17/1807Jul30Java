package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//REQUEST DISPATCHER! Used for forwarding
		HttpSession session = req.getSession();
		session.invalidate();
//		String site = "http://localhost:8088/reimbursement/login" ; 
//		resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY); 
//		resp.setHeader("Location", site);
		req.getRequestDispatcher("home").forward(req, resp);
		
		
		
		
	}
	

}
