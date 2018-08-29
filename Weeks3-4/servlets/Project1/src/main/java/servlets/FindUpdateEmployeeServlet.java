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
import service.EmployeeService;

@WebServlet("/findupdateemployee")
public class FindUpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static EmployeeService bs = new EmployeeService();

    public FindUpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Employees -- Served at: ").append(request.getContextPath());
		
		//JACKSON API
		ObjectMapper mapper = new ObjectMapper();
		
		String[] info = mapper.readValue(request.getReader(), String[].class);
		
		int emp_id = Integer.parseInt((info[0]));
		
		Employee employee = bs.findOne(emp_id);
		
		response.setContentType("application/json");		
		mapper.writeValue(response.getWriter(), employee);		
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
//		Employee b = mapper.readValue(json, Employee.class);
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
