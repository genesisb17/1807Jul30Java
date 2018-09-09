package com.reimb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimb.pojos.Users;
import com.reimb.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	UserService us = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		List<Users> userInfo = us.getAll();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(userInfo);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
		
	}
}
