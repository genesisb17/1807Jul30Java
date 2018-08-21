package com.rev.helloservlets;

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
		System.out.println("in http servlet init()");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.doPost(req,resp);
	
	
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.write("<h1> Hello <b> Tiff </b> !</h1>");	
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("in http destroy()");
	}
}
