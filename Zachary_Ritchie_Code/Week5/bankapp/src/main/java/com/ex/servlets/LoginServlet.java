package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.data.UserRepository;
import com.ex.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	
	static UserRepository repo = new UserRepository();
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		ObjectMapper mapper =  new ObjectMapper();
		String[] info =  mapper.readValue(req.getReader(), String[].class);
		
		User u = repo.findById(Integer.parseInt(info[0]));
		
		if(u==null)
		{
			
		}
		else
		{
			if(u.getPassword().equals(info[1]))
			{
				//write object
			}
			else
			{
				//write null
			}
		}
	}
}
