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
import com.reimb.service.TicketsService;

@WebServlet("/pastTick")
public class EmployeePastServlet extends HttpServlet{

	static TicketsService ts = new TicketsService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = 
                new BufferedReader(new InputStreamReader(
                        req.getInputStream()));
		 String json = "";
	        if(br != null){
	            json = br.readLine();
	        }
	        
        ObjectMapper mapper = new ObjectMapper();
        Reimbursement b = mapper.readValue(json, Reimbursement.class);
        System.out.println(b.toString());
    
        List<Reimbursement> pendInfo = ts.getPast(b);
        
        if(pendInfo.size() > 0) {
	        System.out.println("This is being requested.");
	        //JACKSON API
		        json = mapper.writeValueAsString(pendInfo);
		        PrintWriter out = resp.getWriter();
		        resp.setContentType("application/json");
		        out.write(json);
	        } else
	        {
	            resp.setStatus(404);
	        }
	}
}
