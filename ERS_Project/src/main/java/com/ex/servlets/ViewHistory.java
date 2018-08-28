package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;
import com.ex.services.ReimbursementServices;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ViewHistory
 */
public class ViewHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		ReimbursementServices viewAll = new ReimbursementServices();
		List<Reimbursement> results = viewAll.getAll(user.getUserid());
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(results);
		PrintWriter out = response.getWriter();
	}
}
