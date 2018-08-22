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

public class HelloServlet extends GenericServlet {
	
	static int counter = 0;
	/*
		LIFECYCLE OF A SERVLET! init() service() destroy()
		init is called by the container when the servlet is 
		initialized. here you can configure things like 
		parameters, loggers, etc. basically anything you want
		to happen upon initialization of this servlet
		
		the container then calls the service() method every 
		time a request is sent to the url-pattern that you have
		assigned this servlet. basically this is the part
		where the servlet "services" the request
		
		lastly, the container calls destroy which will deallocate
		memory to the servlet. we often don't see this happen bc
		we don't typically limit the lifetime of the servlet, 
		and if we simply stop the app from running, this method 
		call is not shown
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("INITIALIZING HELLO SERVLET");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest req, 
			ServletResponse res) throws ServletException, IOException {		
		System.out.println("--- IN HELLOSERVLET service() -- count: " + counter);
		String counter = null;
		System.out.println("--- IN HELLOSERVLET service() -- count" + counter);
		
		PrintWriter writer = res.getWriter();
		
		//SERVLET CONTEXT is any config details applying to the entire servlet container
		String bio = getServletContext().getInitParameter("Bio");
		
		writer.println("HELLO WORLD! WELCOME TO JAVA SERVLETS!"
				+ "About me: " + bio);

	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("IN HELLOSERVLET destroy()");
	}
}