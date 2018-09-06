package com.ex.servlets;

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

import com.ex.pojos.Reimbursement;
import com.ex.service.ReimbService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/userreimbs")
public class ReimbUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static ReimbService rService = new ReimbService();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		System.out.println("This is post data!");
//        
        String json = "";
        ObjectMapper mapper = null;
        BufferedReader br = new BufferedReader(new InputStreamReader( req.getInputStream() ));
        
        if (br != null) {
            json = br.readLine();
        }
        
//        System.out.println(json);
//        
        mapper = new ObjectMapper();
        
        Reimbursement reimbObj = mapper.readValue(json, Reimbursement.class);
//        
        System.out.println(reimbObj.toString());
//        
//        rService.findReimbursementsById(reimbObj.getAuthor());
		
		List<Reimbursement> reimbs = rService.findReimbursementsById(reimbObj.getAuthor());
		if(reimbs.size()>0) {
			
			// JACKSON API
//			ObjectMapper mapper = new ObjectMapper();
			String jsonOut = mapper.writeValueAsString(reimbs);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(jsonOut);
		} else {
			resp.setStatus(404);
		}
        
		
	}

}
