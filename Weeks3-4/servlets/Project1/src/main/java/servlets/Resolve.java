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
	static int employeee;
	static int temp_reimb;
	static int temp_status;

    public Resolve() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Employees -- Served at: ").append(request.getContextPath());
		
		//JACKSON API
		ObjectMapper mapper = new ObjectMapper();
		
		String[] info = mapper.readValue(request.getReader(), String[].class);
		System.out.println(info[1]);
		temp_reimb = Integer.parseInt(info[0]);
		employeee = Integer.parseInt(info[1]);
		temp_status = Integer.parseInt(info[2]);
		
		bs.resolveReimbursement(temp_reimb, employeee,temp_status);
	
	}
}
//for testing
//{
//	"reimb_id":41,
//	"resolver_id":9,
//	"status_id": 3
//}	