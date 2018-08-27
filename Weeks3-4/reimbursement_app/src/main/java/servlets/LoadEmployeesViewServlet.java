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

@WebServlet("/employees")
public class LoadEmployeesViewServlet extends HttpServlet{

	static final long serialVersionUID = 1L;
	static EmployeeService bs = new EmployeeService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<Employee> employees = bs.getAll();
			if(employees.size()>0) {
				
				//JACKSON API
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(employees);
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
		Employee b = mapper.readValue(json, Employee.class);
		System.out.println(b.toString());
		
		b = bs.save(b);
		System.out.println(b.toString());
		
		String ret = mapper.writeValueAsString(b);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(ret);
	}
}