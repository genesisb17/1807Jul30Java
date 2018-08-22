package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/doStuff")
public class ajaxServlet extends HttpServlet 
{
	static int counter = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		PrintWriter out = resp.getWriter();
		String info1 = req.getContentType();
		String info2 = req.getProtocol();
		
		out.write("Request #: " + ++counter
				+ "\nContext Path: "+ info1
				+ "\nProtocal : " + info2);
	}	
}
