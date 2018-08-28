package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.Employee;
import service.EmployeeService;

@WebServlet("/login")
public class Login extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	static EmployeeService service = new EmployeeService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		ObjectMapper mapper = new ObjectMapper();
	
		String[] userInfo = mapper.readValue(req.getReader(), String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		PrintWriter out = resp.getWriter();
		
		Employee ee = new Employee();
		ee.setEmp_username(username);
		
		//get the user by username
		Employee temp = service.findOne(ee);
		
		if(temp.getEmp_username() == null)
		{
			out.write("Username doesnt exist");
		}
		else if(!temp.getEmp_password().equals(password))
		{
			//if invalid password
			temp.setEmployee_id(0);
			temp.setEmp_password(null);
		}
		else
		{
			HttpSession session = req.getSession();
			session.setAttribute("employee", temp);
		}
	
		resp.setContentType("application/json");
		
		mapper.writeValue(resp.getWriter(), temp);
	}	
}