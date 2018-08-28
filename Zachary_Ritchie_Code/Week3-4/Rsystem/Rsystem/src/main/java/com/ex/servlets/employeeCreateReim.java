package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.ers_reimbursement;
import com.ex.service.ers_reimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/employeeCreateReim")
public class employeeCreateReim extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		/*
		 * 1. amount
		 * 2. description
		 * 						2/1. receipt
		 * 3. author
		 * 4. type id 
		 */

		ers_reimbursementService service = new ers_reimbursementService();	
		
		ObjectMapper mapper = new ObjectMapper();
		
		String[] userInfo = mapper.readValue(req.getReader(), String[].class);
		
		service.saving(userInfo);
		
		//ers_reimbursement temp = 
		
		//resp.setContentType("application/json");
		
		//mapper.writeValue(resp.getWriter(), temp);
	}
}
