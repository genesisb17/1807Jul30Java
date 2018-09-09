package com.reimb.servlets;

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
import com.reimb.pojos.Reimbursement;
import com.reimb.pojos.Users;
import com.reimb.service.TicketsService;

@WebServlet("/fmUpdate")
public class FinanceMaServlet extends HttpServlet{
	static TicketsService ts = new TicketsService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Reimbursement> reimbInfo = ts.findAll();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbInfo);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = 
                new BufferedReader(new InputStreamReader(
                        req.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        Reimbursement b = mapper.readValue(json, Reimbursement.class);
        System.out.println(b.toString());
        ts.findOne(b);
        String ret = mapper.writeValueAsString(b);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        out.write(ret);
	}
}

