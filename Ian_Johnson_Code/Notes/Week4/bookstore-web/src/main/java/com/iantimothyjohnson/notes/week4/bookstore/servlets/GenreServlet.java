package com.iantimothyjohnson.notes.week4.bookstore.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iantimothyjohnson.notes.week4.bookstore.pojos.Genre;
import com.iantimothyjohnson.notes.week4.bookstore.service.GenreService;

@WebServlet("/genres")
public class GenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper mapper = new ObjectMapper();
	private GenreService gs = new GenreService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Genre> genres = gs.getAll();
		// Return books; use the Jackson API to convert to JSON.
		resp.setContentType("application/json");
		mapper.writeValue(resp.getWriter(), genres);
	}
}
