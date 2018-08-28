package com.ex.servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.ers_reimbursement;
import com.ex.service.ers_reimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/employeeGetReim")
public class employeeGetReim extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		/*
		 * 1. id
		 */
		
		ers_reimbursementService service = new ers_reimbursementService();
		
		ObjectMapper mapper = new ObjectMapper();
		
		String[] userInfo = mapper.readValue(req.getReader(), String[].class);
		String author = userInfo[0];
		
		List<ers_reimbursement> ersObj = service.getEmployeeReim(author);
		
		String temp = mapper.writeValueAsString(ersObj);
		
		resp.setContentType("application/json");
		
		mapper.writeValue(resp.getWriter(), temp);
	}
	
}
