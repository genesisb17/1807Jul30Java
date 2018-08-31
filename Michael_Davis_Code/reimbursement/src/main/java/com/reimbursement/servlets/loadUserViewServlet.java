package com.reimbursement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loadUser")
public class loadUserViewServlet extends HttpServlet{
//REPLACING WITH LOADVIEWSERVLET!

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	resp.addHeader("Access-Control-Allow-Origin", "*");
		//resp.addHeader("Access-Control-Allow-Methods", "GET, POST, HEAD");
	System.out.println("Inside DOGET");
		req.getRequestDispatcher("partials/usersView.html").forward(req, resp);
	}
	
}