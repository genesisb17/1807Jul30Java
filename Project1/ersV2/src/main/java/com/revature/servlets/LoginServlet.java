package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	UserService service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<User> userInfo = service.getAllUsers();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(userInfo);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		System.out.println("we are responding with -> ");
		System.out.println(json);
		
		out.write(json);
		
	}

}
