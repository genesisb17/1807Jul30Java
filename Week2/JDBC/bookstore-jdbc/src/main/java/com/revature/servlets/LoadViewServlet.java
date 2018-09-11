package com.revature.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadViewServlet extends HttpServlet{
//	private static Logger log = Logger.getLogger(LoadViewServlet.class);
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		//log.trace("Initialize LoadViewServlet");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resource = "partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resource).forward(req, resp);
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		//log.info("REQUEST SENT TO: " + req.getRequestURI());
		//log.info("PATH: " + req.getPathInfo());
		switch(req.getRequestURI()) {
		case "/bookstore/home.view": 
			return "homeView";
		case "/bookstore/genre.view":
			return "genreView";
		case "/bookstore/books.view":
			return "booksView";
		default: 
			return "errorView";
		}
	}
}
