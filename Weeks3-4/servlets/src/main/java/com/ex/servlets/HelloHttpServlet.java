package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloHttpServlet extends HttpServlet
{
	@Override
	public void init() throws ServletException
	{
		// TODO Auto-generated method stub
		super.init();
		System.out.println("In Http hellohttpservlet init");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("In http servlet doget");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		
		String info = getServletConfig().getInitParameter("Info");
		out.write("<h> Hello <b>Zack</b> ! </h>"
				+ "<br> Random init params: <i>" + info + "</i>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		PrintWriter out = resp.getWriter();
		out.write("In HTTPSERVLET POST METHOD");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("In hellohttpservlet destroy()");
	}

	
}
