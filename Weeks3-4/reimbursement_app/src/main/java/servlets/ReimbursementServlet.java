package servlets;

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

import pojos.Reimbursement;
import service.ReimbursementService;

@WebServlet("/reimbursements   ")
public class ReimbursementServlet extends HttpServlet{

	//SERVICE CLASS! DO NOT CALL DAO METHODS FROM SERVLET
	static ReimbursementService bs = new ReimbursementService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<Reimbursement> reimbursements = bs.getAll();
			if(reimbursements.size()>0) {
				//return books 
				
				//JACKSON API
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(reimbursements);
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				out.write(json);
				
			}else {
				resp.setStatus(404);
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TAKE BOOK JSON STRING AND TURN TO JAVA OBJ
		
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
	}
}