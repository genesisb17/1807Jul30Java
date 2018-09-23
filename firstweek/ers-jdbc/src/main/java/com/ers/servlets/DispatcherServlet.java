package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resource = "partials/" + MasterDispatcher.process(request, response) + ".html";	
		request.getRequestDispatcher(resource).forward(request, response);
	
		
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().write(mapper.writeValueAsString(MasterDispatcher.process(request, response)));	
	}

}