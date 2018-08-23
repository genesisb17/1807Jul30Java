package com.iantimothyjohnson.notes.week4.bookstore.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ViewServlet.class);

	@Override
	public void init() throws ServletException {
		super.init();
		logger.trace("Initializing ViewServlet.");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resource = "partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resource).forward(req, resp);
	}

	static String process(HttpServletRequest req, HttpServletResponse resp) {
		switch (req.getServletPath()) {
		case "/home.view":
			return "homeview";
		case "/book.view":
			return "bookview";
		case "/genre.view":
			return "genreview";
		case "/author.view":
			return "authorview";
		default:
			return "errorview";
		}
	}
}
