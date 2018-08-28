package com.servicepackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.EmployeePOJO;

public class EmployeeService {

	static EmployeeDAO eDao = new EmployeeDAO();
	
	public static EmployeePOJO login(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		EmployeePOJO employee = null;
		try {
			employee = mapper.readValue(request.getReader(), EmployeePOJO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		EmployeePOJO authorized = eDao.findOne(employee.getUsername());
		if (employee.getPw().equals(authorized.getPw())) {
			return eDao.findOne(employee.getUsername());
		}
		return null;
	}
	
	public static List<EmployeePOJO> getAllEmp(HttpServletRequest request, HttpServletResponse response) {
		
		List<EmployeePOJO> employees = eDao.findAll();
		
		return employees;
	}

}
