package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloHttpServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("IN HTTP SERLVET INIT");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("IN HTTP DESTROY");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		System.out.println("IN HTTP SERVLET DOGET");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		//Servlet Config is any configuration detail about this particular servlet
		String info = getServletConfig().getInitParameter("info");
		out.write("<h1> Hello <b>Genesis</b> ! </h1>"
				+ "<br> Random init params: <i>" + info + "</i>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		
		
		PrintWriter out = resp.getWriter();
		out.write("IN HTTPSERVLET POST METHOD!");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
	
}
