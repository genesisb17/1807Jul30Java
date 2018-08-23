package com.iantimothyjohnson.notes.week4.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/do-stuff")
public class AJAXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int counter = 1;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String info1 = req.getContextPath();
		String info2 = req.getProtocol();
		Enumeration<String> info3 = req.getHeaderNames();
		StringBuilder headers = new StringBuilder();
		while (info3.hasMoreElements()) {
			headers.append(info3.nextElement());
			headers.append("\n");
		}

		out.print("REQUEST # " + counter++ + "\nContext path: " + info1 + "\nProtocol: " + info2 + "\nHeader names: "
				+ headers);
	}
}
