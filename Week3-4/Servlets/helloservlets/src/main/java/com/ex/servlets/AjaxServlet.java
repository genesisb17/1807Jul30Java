package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/doStuff")
public class AjaxServlet extends HttpServlet {

	static int counter = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String info1 = req.getContextPath();
		String info2 = req.getProtocol();
		String info3 = req.getContentType();

		out.write("Request #" + ++counter
				+ "<br>Context Path: " + info1 + 
				"<br>Protocol: " + info2 +
				"<br>Content Type: " + info3);
		
		
	}
	
}
