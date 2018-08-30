package com.servicepackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.EmployeePOJO;
import com.pojo.EmployeeRolesPOJO;
import com.pojo.ReimbursementPOJO;

public class EmployeeService {

	static EmployeeDAO eDao = new EmployeeDAO();
	static ObjectMapper mapper = new ObjectMapper();
	
	public static EmployeePOJO login(HttpServletRequest request, HttpServletResponse response) {
		EmployeePOJO employee = null;
		try {
			employee = mapper.readValue(request.getReader(), EmployeePOJO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		EmployeePOJO authorized = eDao.findOneByUname(employee.getUsername());
		if (employee.getPw().equals(authorized.getPw())) {
			return eDao.findOneByUname(employee.getUsername());
		}
		return null;
	}
	
	public static List<EmployeePOJO> getAllEmp(HttpServletRequest request, HttpServletResponse response) {
		List<EmployeePOJO> employees = eDao.findAll();
		
		return employees;
	}

}
