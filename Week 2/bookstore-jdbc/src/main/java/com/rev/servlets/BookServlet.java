package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Book;
import com.rev.service.BookService;

@WebServlet("/books")

public class BookServlet extends HttpServlet{
	static BookService bs = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book> books = bs.getAllBooks();
		
		if(books.size() > 0) {
			System.out.println("IT WORKS");
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(books);
			PrintWriter out = resp.getWriter();
			resp.setContentType("applcation/json");
			out.write(json);
		} else {
			resp.setStatus(404);
		}
	}
}
