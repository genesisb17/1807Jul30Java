package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.exceptions.NotYetImplementedException;

public class ServletDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("IN SERVLET DISPATCHER DOGET");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("IN SERVLET DISPATCHER DOPOST");
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			PrintWriter out = response.getWriter();
			String json = mapper.writeValueAsString(MasterDispatcher.routeTraffic(request, response));
			System.out.println("MasterDispatcher returned: " + json);
			out.write(json);
		} catch (NotYetImplementedException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

}
