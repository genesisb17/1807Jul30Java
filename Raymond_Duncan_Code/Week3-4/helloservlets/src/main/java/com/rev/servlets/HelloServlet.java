/**
 * 
 */
package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Ray
 *
 */
public class HelloServlet extends GenericServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	
	/*
	 * LIFECYCLE OF A SERVLET init(), service, desroy
	 * init is called by the container when the servlet is initialized. 
	 * Here you can configure things like parametrs, loggers, etc., basically anything you want to 
	 * happen upon initializatino of theis servlet
	 * 
	 * the container...CHECK GITHUB FOR THE REST OF THESE NOTES!
	 */
	static int counter;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		counter = 0;
		System.out.println("INITIALING HELLO SERVLET");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--- IN HELLOSERVLET service() --- count: " + counter++);
		
		String bio = getServletConfig().getInitParameter("Bio");
		
		PrintWriter writer = res.getWriter();
		writer.println("HELLO WORLD! WELCOME TO JAVA SERVLETS!\n" + bio);

	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("DESTROYING HELLO SERVLET");
	}

}
