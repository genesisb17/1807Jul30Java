package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

// could use webservlet annotation but we won't
public class LoadViewsServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(LoadViewsServlet.class);
	
	@Override
	public void init() throws ServletException {
		super.init();
		log.trace("Initializing LoadViewsServlet");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resource = "partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resource).forward(req, resp);
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		log.info("REQUEST SENT TO: " + req.getRequestURI());	// url pattern
		log.info("PATH: " + req.getContextPath());
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
