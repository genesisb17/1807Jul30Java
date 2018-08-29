package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.Reimbursement;
import service.ReimbursementService;

@WebServlet("/findupdatereimbursement")
public class FindUpdateReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ReimbursementService bs = new ReimbursementService();

    public FindUpdateReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("reimbursements -- Served at: ").append(request.getContextPath());
		
		//JACKSON API
		ObjectMapper mapper = new ObjectMapper();
		
		String[] info = mapper.readValue(request.getReader(), String[].class);
		
		int reimb_id = Integer.parseInt((info[0]));
		
		Reimbursement reimbursement = bs.findOne(reimb_id);
		
		response.setContentType("application/json");		
		mapper.writeValue(response.getWriter(), reimbursement);		
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		doGet(request, response);
//		
//		BufferedReader br = 
//				new BufferedReader(new InputStreamReader(
//						request.getInputStream()));
//		String json = "";
//		if(br != null){
//			json = br.readLine();
//		}
//		
//		ObjectMapper mapper = new ObjectMapper();
//		Reimbursement b = mapper.readValue(json, Reimbursement.class);
//		//System.out.println(b.toString());
//		
//		b = bs.update(b);
//	//	System.out.println(b.toString());
//		
//		String ret = mapper.writeValueAsString(b);
//		PrintWriter out = response.getWriter();
//		response.setContentType("application/json");
//		out.write(ret);
//	}

}
