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
import com.rev.pojos.Genre;
import com.rev.service.GenreService;

@WebServlet("/genres")

public class GenreServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		GenreService service = new GenreService();
		List<Genre> genres = service.getAll();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(genres);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
		
	}
}
