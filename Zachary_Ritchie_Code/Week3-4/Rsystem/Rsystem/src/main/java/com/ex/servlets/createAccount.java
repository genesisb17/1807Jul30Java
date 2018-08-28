package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.ers_users;
import com.ex.service.ers_usersService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/createAccount")
public class createAccount extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	static ers_usersService service = new ers_usersService();
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		/*
		 * 1. username
		 * 2. password
		 * 3. firstname
		 * 4. password
		 * 5. email 
		 * 6. role
		 */
		
		// 2. Initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. Convert received JSON to String array
		String[] userInfo = mapper.readValue(req.getReader(), String[].class);
		
		//call service layer and return object
		ers_users temp = service.saving(userInfo);
		
		//TODO: check to see if user is null or not. If null input was invalid
		
		//I am going to send in "type" json to "front end"
		resp.setContentType("application/json");
		
		//writes json to resp
		mapper.writeValue(resp.getWriter(), temp);
	}	
}
