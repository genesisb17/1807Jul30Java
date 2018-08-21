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
		super.init();
		System.out.println("IN HTTP SERVLET INIT");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("IN HTTP DESTROY");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("IN HTTP DOGET");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		// Servlet Config is any configuration detail about this particular ... (see github)
		String info = getServletConfig().getInitParameter("info");
		out.write("<h1>Hello <b>Genesis</b>!</h1>"
				+ "<br> Random init params: <i>" + info + "</i>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		super.doPost(req,  resp);
		
		PrintWriter out = resp.getWriter();
		out.write("IN HTTPSERVLET POST METHOD!");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPut(req,  resp);
	}

}
