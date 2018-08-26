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

import com.ex.pojos.ers_users;
import com.ex.service.ers_usersService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class Login extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	static ers_usersService service = new ers_usersService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//super.doPost(req, resp);
		
		// 2. Initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. Convert received JSON to String array
		String[] userInfo = mapper.readValue(req.getReader(), String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		PrintWriter out = resp.getWriter();
		
		//get the user by username
		ers_users temp = service.findOne(username);
		
		if(temp == null)
		{
			out.write("Username doesnt exist");
		}
		else if(!temp.getErs_password().equals(password))
		{
			//if invalid password
			temp.setErs_user_id(0);
			temp.setErs_password(null);
		}
		else
		{
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);
		}
		
		//im send json to "front end"
		resp.setContentType("application/json");
		
		//writes json to resp
		mapper.writeValue(resp.getWriter(), temp);
	}	
}
