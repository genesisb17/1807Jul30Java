package service;

import java.util.List;

import dao.DAO;
import dao.EmployeeDAO;
import pojos.Employee;
import pojos.Employee;

public class EmployeeService {
	
	static DAO<Employee, Integer> eDAO = new EmployeeDAO();
	
	public List<Employee> getAll() {
		return eDAO.getAll();
	}

	public Employee findOne(Employee obj) {
		return eDAO.findOne(obj);
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
	
}
