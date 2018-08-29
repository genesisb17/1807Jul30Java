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

import pojos.Employee;
import pojos.Reimbursement;
import service.EmployeeService;
import service.ReimbursementService;

@WebServlet("/resolve")
public class Resolve extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ReimbursementService bs = new ReimbursementService();
	static EmployeeService es = new EmployeeService();
	static Employee employeee;

    public Resolve() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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


}
