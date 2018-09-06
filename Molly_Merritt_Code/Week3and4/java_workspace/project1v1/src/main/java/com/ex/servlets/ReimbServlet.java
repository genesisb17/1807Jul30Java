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
import com.ex.pojos.User;
import com.ex.service.ReimbService;
import com.ex.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/reimbursements")
public class ReimbServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static ReimbService rService = new ReimbService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Reimbursement> reimbs = rService.findAllReimbursements();
		if(reimbs.size()>0) {
			
			// JACKSON API
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(reimbs);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		} else {
			resp.setStatus(404);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("This is post data!");
        
        String json = "";
        ObjectMapper mapper = null;
        BufferedReader br = new BufferedReader(new InputStreamReader( req.getInputStream() ));
        
        if (br != null) {
            json = br.readLine();
        }
        
        System.out.println(json);
        
        mapper = new ObjectMapper();
        
        Reimbursement reimbObj = mapper.readValue(json, Reimbursement.class);	// json must be all on one line
        
        System.out.println(reimbObj.toString());
        
        rService.addReimbursement(reimbObj);
        
        //////////////////////////////////////
        
		List<Reimbursement> _reimbs = rService.findAllReimbursements();
		if(_reimbs.size()>0) {
			
			// JACKSON API
			ObjectMapper _mapper = new ObjectMapper();
			String _json = _mapper.writeValueAsString(_reimbs);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(_json);
		} else {
			resp.setStatus(404);
		}
		
	}
	
	
}
