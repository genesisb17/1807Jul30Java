package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DAO;
import dao.EmployeeDAO;
import pojos.Employee;

public class EmployeeService {
	
	static DAO<Employee, Integer> eDAO = new EmployeeDAO();
	
	
	public List<Employee> getAll() {
		return eDAO.getAll();
	}

	public Employee findOne(Employee obj) {
		return eDAO.findOne(obj);
	}

	public Employee findOne(int id) {
		return eDAO.findOne(id);
	}
	
	public Employee save(Employee obj) {
		return eDAO.save(obj);
	}

	public Employee update(Employee obj) {
		return eDAO.update(obj);
	}

	public void delete(Employee obj) {
		// TODO Auto-generated method stub
		System.out.println("You need to write this method");
	}
	
	// 1. Read the Request body (JSON), and set it to the `json` String variable
	// 2. Using the ObjectMapper, map the json into an object of type User
	// 3. Perform rest of logic that requires a User POJO
	public static Employee login(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		Employee emp = null;
		try {
			emp = mapper.readValue(request.getReader(), Employee.class);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		Employee authorized = eDAO.findOne(emp);
		if (EmployeeDAO.getPasswordHash(emp).equals(authorized.getEmp_password()))
			return eDAO.findOne(emp);
		return null;
	}

	public Employee findOne(String emp_username) {
		return eDAO.findOne(emp_username);
	}
}
