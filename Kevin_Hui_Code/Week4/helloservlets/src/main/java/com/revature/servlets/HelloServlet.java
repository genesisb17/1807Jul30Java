/**
 * 
 */
package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Kevin Hui
 *
 */
public class HelloServlet extends GenericServlet {

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("INITIALIZING HELLOSERVLET");
	}
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("--- IN HELLO SERVLET service()");
		PrintWriter writer = res.getWriter(); // get writer from response
		writer.println("HELLO WORLD, JAVA SERVLETS ARE COOL!");
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("IN HELLOSERVLET destroy()");
	}

}
