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
 * @author Owner
 *
 */
public class HelloServlets extends GenericServlet 
{
	static int counter = 0;
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	
	@Override
	public void init() throws ServletException
	{
		// TODO Auto-generated method stub
		super.init();
		System.out.println("In Http HelloServlet init");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		System.out.println("--- In HelloServlet service() -- counter " + counter);
		
		PrintWriter writer = res.getWriter();
		String bio = getServletContext().getInitParameter("Bio");
		writer.println("Hello world! welcome to java servlets!"
				+ " About me: " + bio);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("In helloservlet destroy()");
	}

}
