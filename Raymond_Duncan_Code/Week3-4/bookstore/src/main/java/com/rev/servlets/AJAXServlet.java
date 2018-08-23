package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/doStuff")
public class AJAXServlet extends HttpServlet {
	
	static int counter = 0;
	

	@Override
	public void init() throws ServletException {
		System.out.println("INITIALIZING AJAX SERVLET");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String info1 = req.getContextPath();
		String info2 = req.getProtocol();
		String info3 = req.getLocalName();
		String info4 = req.getPathInfo();
		Enumeration<String> info5 = req.getHeaderNames();
		System.out.println("Writing from AJAX Servlet");
		
		out.write("REQUEST #" + ++counter + 
				"\nContext Path: " + info1 +
				"\nProtocol: " + info2 + 
				"\nLocal Name: " + info3 + 
				"\nPath Info: " +  info4 + 
				"\nHeader Names: " + info5.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
