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

import pojos.Employee;
import service.EmployeeService;

@WebServlet("/allsaveemployee")
public class AllSaveEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static EmployeeService bs = new EmployeeService();

    public AllSaveEmployeeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Employees -- Served at: ").append(request.getContextPath());
		
		List<Employee> employees = bs.getAll();
		if(employees.size()>0) {
			//return books 
			
			//JACKSON API
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(employees);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
			
		}else {
			response.setStatus(404);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(
						request.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		Employee b = mapper.readValue(json, Employee.class);
		//System.out.println(b.toString());
		
		b = bs.save(b);
	//	System.out.println(b.toString());
		
		String ret = mapper.writeValueAsString(b);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(ret);
	}

}
