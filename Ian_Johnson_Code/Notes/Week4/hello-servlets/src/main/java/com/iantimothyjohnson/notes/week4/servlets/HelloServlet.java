package com.iantimothyjohnson.notes.week4.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Initialized HelloServlet.");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("In HelloServlet service method.");
		PrintWriter pw = res.getWriter();
		String bio = getServletContext().getInitParameter("bio");
		pw.println("Hello, world! Welcome to Java Servlets! " + bio);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destroyed HelloServlet.");
	}
}
