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

@WebServlet("/ticket")
public class TicketServlet extends HttpServlet{
	
	TicketsService ts = new TicketsService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * 
		 * 	statusId,
		 *	userId:	
		 *	ticketId
		 * 
		 * */
		
		System.out.println("Inside the doPost of employee");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        System.out.println(json);
        
        ObjectMapper mapper = new ObjectMapper();
        Tickets ticket = mapper.readValue(json, Tickets.class);
        
        System.out.println("ticket toString() ");
        System.out.println(ticket.toString());
        
//        userId=2, ticketId=22, statusId=2
        
//        ts.addTicket(b);
        ts.updateTicket(ticket);
        
        System.out.println("After ticket update");

//////////////////////////////////////////////////////////////////////
        
//		int user_id = Integer.parseInt(req.getParameter("userId"));
		
//		List<Tickets> tickets = ts.getAllTickets_ofUser(user_id);
        
//		List<Tickets> tickets = ts.getAllTickets();
		
//		ObjectMapper responseMapper = new ObjectMapper();
//		String responseJson = responseMapper.writeValueAsString(tickets);
		PrintWriter out = resp.getWriter();
		
//		System.out.println(json);
		
		resp.setContentType("application/json");
		out.write("I responded");
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		List<Tickets> tickets = null;
		System.out.println("hitting ticket servlet");
		
		String userId = req.getParameter("userId");
		String roleId = req.getParameter("roleId");
		
		
		int user_id = Integer.parseInt(userId);
		
		if (!roleId.equals("2")) {
			System.out.println("we are employee");
			tickets = ts.getAllTickets_ofUser(user_id);
		}
		else {	 // roleId ---> 2	
			System.out.println("we are manager!");
			tickets = ts.getAllTickets();
			System.out.print("--> " + tickets.toString());
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(tickets);
		PrintWriter out = resp.getWriter();
		
//		System.out.println(json);
		
		resp.setContentType("application/json");
		out.write(json);
	}
	
}
