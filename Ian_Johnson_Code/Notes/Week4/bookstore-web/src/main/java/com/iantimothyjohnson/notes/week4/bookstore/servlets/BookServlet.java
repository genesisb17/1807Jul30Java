package com.iantimothyjohnson.notes.week4.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iantimothyjohnson.notes.week4.bookstore.pojos.Book;
import com.iantimothyjohnson.notes.week4.bookstore.service.BookService;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bs;

	@Override
	public void init() throws ServletException {
		super.init();
		bs = new BookService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book> books = bs.getAll();
		if (books.size() > 0) {
			// Return books; use the Jackson API to convert to JSON.
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(books);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.print(json);
		} else {
			resp.setStatus(404);
		}
	}
}
