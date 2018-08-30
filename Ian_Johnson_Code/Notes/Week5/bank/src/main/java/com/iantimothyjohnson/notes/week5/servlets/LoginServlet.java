package com.iantimothyjohnson.notes.week5.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iantimothyjohnson.notes.week5.data.UserRepository;
import com.iantimothyjohnson.notes.week5.models.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final UserRepository userRepo = new UserRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] credentials = mapper.readValue(req.getReader(), String[].class);
		User user = userRepo.findByUsername(credentials[0]);
		resp.setContentType("application/json");
		if (user == null || !user.getPassword().equals(credentials[1])) {
			resp.setStatus(403);
			mapper.writeValue(resp.getWriter(), null);
		} else {
			mapper.writeValue(resp.getWriter(), user);
		}
	}
}
