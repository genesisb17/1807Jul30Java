package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.User;
import com.ex.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	// SERVICE CLASS! DO NOT CALL DAO METHODS FROM SERVLET
	static UserService uService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int userId = 1;
//		User users = uService.getUser(userId);
		List<User> users = uService.getAllUsers();
//		User user = uService.getAllUsers();
		if(users.size()>0) {
			// return users
			
			// JACKSON API
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(users);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		} else {
			resp.setStatus(404);
		}
	}

}