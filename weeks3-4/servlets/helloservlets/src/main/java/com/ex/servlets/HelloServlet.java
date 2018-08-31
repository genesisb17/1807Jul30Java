package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
 
public class HelloServlet extends GenericServlet {
	
	static int counter() {
		return 0;
	}
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 * 
	 * LifeCycle of a servlet! init() service() destroy()
	 * 
	 * here you can configure parameters loggers etc anything you want to happen on request
	 * 
	 * the container then calls the service method every time a request is sent to the url pattern you
	 * have assigned
	 * basically this is the part where the servlet services the request
	 * 
	 * lastly the container calls destroy which will deallocate memorty to the servlet we often dont see
	 * this happen bc we dont usually limit the lifetime of the servlet and if
	 * we stop the app from running this method call is not shown
	 * 
	 */
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Initializing hello servlet!");
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("In destroy");
	}
	
 
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In HelloServlet service()");
		PrintWriter writer=res.getWriter();
		writer.println("Welcome to Java servlets!");
		String bio=getServletContext().getInitParameter("Bio");
		System.out.println("All about me: "+bio);
		
		
	}

}
