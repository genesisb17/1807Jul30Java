/**
 * 
 */
package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ray
 *
 */
public class HelloHTTPServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("INITIALIZING HTTP SERVLET");
	}
	
	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		
		System.out.println("IN HTTP SERVLET DOGET");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		//Servlets configs are any configuration detail about this particular servlet
		String info = getServletConfig().getInitParameter("Info");
		out.write("<h1> Hello World! </h1><i>" + info + "</i>");
	};
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		PrintWriter out = resp.getWriter();
		out.write("IN HTTPSERVLET POST METHOD");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("DESTROYING HTTP SERVLET");
	}
}
