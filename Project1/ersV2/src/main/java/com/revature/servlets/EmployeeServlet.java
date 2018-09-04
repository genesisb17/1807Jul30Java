package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Tickets;
import com.revature.service.TicketsService;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet{
	
	static TicketsService ts = new TicketsService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Inside the doPost of employee");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        
        Tickets b = mapper.readValue(json, Tickets.class);
        
        System.out.println(b.toString());
        System.out.println("AMOUNT: " + b.getCash());
        
        ts.addTicket(b);

//////////////////////////////////////////////////////////////////////
        
		int user_id = Integer.parseInt(req.getParameter("userId"));
		
		List<Tickets> tickets = ts.getAllTickets_ofUser(user_id);
        
//		List<Tickets> tickets = ts.getAllTickets();
		
		ObjectMapper responseMapper = new ObjectMapper();
		String responseJson = responseMapper.writeValueAsString(tickets);
		PrintWriter out = resp.getWriter();
		
//		System.out.println(json);
		
		resp.setContentType("application/json");
		out.write(responseJson);
        
        
	}   
}
