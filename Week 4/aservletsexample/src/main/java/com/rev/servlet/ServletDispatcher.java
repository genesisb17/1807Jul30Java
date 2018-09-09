package com.rev.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


public class ServletDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	 public ServletDispatcher() {
	        super();
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("application/json");
			
			ObjectMapper mapper = new ObjectMapper();
			
			response.getWriter().write(mapper.writeValueAsString(MasterDispatcher.process(request, response)));
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

}
