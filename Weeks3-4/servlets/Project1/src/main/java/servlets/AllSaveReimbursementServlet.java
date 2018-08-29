package servlets;

import java.util.List;
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
import service.EmployeeService;
import service.ReimbursementService;

@WebServlet("/allsavereimbursement")
public class AllSaveReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ReimbursementService bs = new ReimbursementService();
	static EmployeeService es = new EmployeeService();
	
    public AllSaveReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Employees -- Served at: ").append(request.getContextPath());
		
		List<Reimbursement> reimbursements = bs.getAll();
		if(reimbursements.size()>0) {
			
			//JACKSON API
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(reimbursements);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
			
		}else {
			response.setStatus(404);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();

		Reimbursement b = mapper.readValue(request.getReader(), Reimbursement.class);
		System.out.println(b.toString());
		
		b = bs.save(b);
		System.out.println(b.toString());
		
		String ret = mapper.writeValueAsString(b);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(ret);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		BufferedReader br = 
//				new BufferedReader(new InputStreamReader(
//						request.getInputStream()));
////		System.out.println(br);
//		String json = "";
//		if(br != null){
//			json = br.readLine();
//		}
//		
//		ObjectMapper mapper = new ObjectMapper();
//
//		String[] info = mapper.readValue(request.getReader(), String[].class);		
//		Reimbursement b = new Reimbursement();
//		b.setAmount(Integer.parseInt(info[0]));
//		b.setDescription(info[1]);
//		b.setType_id(Integer.parseInt(info[2]));
//		b.setStatus_id(Integer.parseInt(info[3]));
//		
//		b = bs.save(b);
//		System.out.println(b.toString());
//		
//		String ret = mapper.writeValueAsString(b);
//		PrintWriter out = response.getWriter();
//		response.setContentType("application/json");
//		out.write(ret);
//	}
//	{ //place in postman to test
//		"amount":5,
//		"submitted": "null",
//		"resolved": "null",
//		"description":"postman description",
//		"author": 9,
//		"resolver_id": 10,
//		"status_id": 1,
//		"type_id": 2
//	}
	

}
