/**
 * 
 */
package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Benjamin Martin
 *
 */
public class HelloServlet extends GenericServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
		
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("INITIALIZING HELLO SERVLET");
	}
	
	@Override
	public void service(ServletRequest req, 
			ServletResponse res) throws ServletException, IOException {
		String counter = null;
		System.out.println("--- IN HELLOSERVLET service() -- count" + counter);
		
		PrintWriter writer = res.getWriter();
		
		String bio = getServletContext().getInitParameter("Bio");
		
		writer.println("HELLO WORLD! WELCOME TO JAVA SERVLETS!"
				+ "About me: " + bio);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("IN HELLOSERVLET destroy()");
	}

}
