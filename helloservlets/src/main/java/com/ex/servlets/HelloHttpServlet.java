package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloHttpServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("IN HTTP SERVLET INIT");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("IN HTTP SERVLET destroy");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		String info = getServletConfig().getInitParameter("info");
		out.write("<h1> Hello <b>Genesis</b> ! </h1>"
				+ "<br> Random init params: <i>" + info + "</i>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		PrintWriter out = resp.getWriter();
		out.write("IN HTTP SERVLET POST METHOD");
	}
	
}