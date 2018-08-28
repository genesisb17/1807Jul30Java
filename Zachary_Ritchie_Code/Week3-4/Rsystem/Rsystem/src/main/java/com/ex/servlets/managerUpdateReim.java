package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.service.ers_reimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/managerUpdateReim")
public class managerUpdateReim extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		/*
		 * 1. id
		 * 2. resolver
		 * 3. status id
		 */
		
		ers_reimbursementService service = new ers_reimbursementService();
		
		ObjectMapper mapper = new ObjectMapper();
		
		int[] userInfo = mapper.readValue(req.getReader(), int[].class);
		
		service.update(userInfo);
	}
}
