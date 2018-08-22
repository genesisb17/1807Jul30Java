package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojo.Books;
import com.ex.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/books")
public class BookServlet extends HttpServlet
{
	static BookService bs = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		List<Books> books = bs.getAll();
		if(books.size()>0)
		{
			//return books
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(books);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/java");
			out.write(json);
		}
		else
		{
			resp.setStatus(404);
		}
	}
}
