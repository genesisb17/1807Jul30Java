package com.servicepackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ReimbursementDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.EmployeePOJO;
import com.pojo.ReimbursementPOJO;

public class ReimbursementService {
	
	static ReimbursementDAO rDao = new ReimbursementDAO();
	static ObjectMapper mapper = new ObjectMapper();
	
	public static List<ReimbursementPOJO> findBySome(HttpServletRequest request, HttpServletResponse response) {
		EmployeePOJO employee = null;
		
		try {
			employee = mapper.readValue(request.getReader(), EmployeePOJO.class);

		} catch (IOException ioe) {
		
		}
		
		List<ReimbursementPOJO> reimbursements = rDao.findBySomeParam(employee.getEmp_id());

		return reimbursements;
	}
	
	public static void submitNew(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementPOJO reimbursement = new ReimbursementPOJO();
		
		try {
			 reimbursement = mapper.readValue(request.getReader(), ReimbursementPOJO.class);

		} catch (IOException ioe) {
		
		}
		
		rDao.submitNew(reimbursement);
		
	}
	
}
