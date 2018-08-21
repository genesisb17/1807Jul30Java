package com.iantimothyjohnson.notes.week4.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("HelloHttpServlet initialized.");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In HelloHttpServlet doGet.");
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");

		String info = getServletConfig().getInitParameter("info");
		String bio = getServletContext().getInitParameter("bio");
		pw.println("<h1>Hello!</h1><br>" + info + "<br>" + bio);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.println("In HTTP servlet POST method.");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("HelloHttpServlet destroyed.");
	}
}
