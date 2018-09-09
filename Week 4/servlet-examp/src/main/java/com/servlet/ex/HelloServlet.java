/**
 * 
 */
package com.servlet.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Virath
 *
 */

//GENERIC SERVLET EXAMPLE

public class HelloServlet extends GenericServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	
	static int counter = 0;
	
	@Override
	public void init() throws ServletException{
		super.init();
		System.out.println("INITIALIZING HELLO SERVET");
	}
	
	@Override
	public void service(ServletRequest req, 
			ServletResponse res) throws ServletException, IOException {
		System.out.println("--- IN HELLOSERVLET service() --count: " + counter);
		
		PrintWriter writer = res.getWriter();
		String bio = getServletContext().getInitParameter("Bio");
		
		writer.println("HELLO WORLD! WELCOME TO JAVA SERVLETS!"
				+ " \nAbout me: \n"+ bio);
		
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("IN HELLOSERVLET destroy()");
	}
}