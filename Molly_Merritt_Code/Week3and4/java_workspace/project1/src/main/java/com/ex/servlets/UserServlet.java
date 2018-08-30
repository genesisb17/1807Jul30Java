package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.User;
import com.ex.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
	
	// SERVICE CLASS! DO NOT CALL DAO METHODS FROM SERVLET
	static UserService uService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<User> users = uService.getAllUsers();
//		if(users.size()>0) {
//			// return users
//			
//			// JACKSON API
//			ObjectMapper mapper = new ObjectMapper();
//			String json = mapper.writeValueAsString(users);
//			PrintWriter out = resp.getWriter();
//			resp.setContentType("application/json");
//			out.write(json);
//		} else {
//			resp.setStatus(404);
//		}
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TAKE BOOK JSON STRING AND TURN TO JAVA OBJ
		
		System.out.println("in doPost method");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(json, User.class);
		
		u = uService.addUser(u);
		
		String ret = mapper.writeValueAsString(u);
//		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
//		out.write(ret);
		
		//
		
//		String name = req.getParameter("username");
//		String pass = req.getParameter("password");
		
		String name = u.getUsername();
		String pass = u.getPassword();
				
//		User u = uService.getUser(name);
		
		System.out.println("LOGGING IN USER " + name  + ":" + pass);
		
		PrintWriter out = resp.getWriter();
		if(u == null) {
//			out.println("Sorry, invalid username");
//			resp.sendRedirect("login");
		}
		else if(!u.getPassword().equals(pass)) {
			out.println("Sorry, invalid passsword");
		}
		else {
			//valid login getSession() - returns 
			//current session or creates new one if none exists
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			System.out.println(session.getId());
			out.println("Welcome, " + name + "!");
			resp.sendRedirect("home");
		}
	}
	
}