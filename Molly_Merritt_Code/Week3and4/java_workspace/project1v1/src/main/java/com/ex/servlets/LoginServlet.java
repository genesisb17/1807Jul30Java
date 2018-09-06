package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.User;
import com.ex.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserService uService = new UserService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("This is post data!");

        User u = UserService.login(request, response);
        System.out.println(u.toString());
        ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(u);
		PrintWriter writer = response.getWriter();
		writer.write(json);
        
	}

}
