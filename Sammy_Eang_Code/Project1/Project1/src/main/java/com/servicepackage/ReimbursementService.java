package com.servicepackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ReimbursementDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.EmployeePOJO;
import com.pojo.EmployeeRolesPOJO;
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
	
	public static ReimbursementPOJO submitNew(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementPOJO reimbursement = new ReimbursementPOJO();
		
		try {
			 reimbursement = mapper.readValue(request.getReader(), ReimbursementPOJO.class);

		} catch (IOException ioe) {
		
		}
		
		return rDao.submitNew(reimbursement);
		
	}
	
	public static List<ReimbursementPOJO> getAllReimb(HttpServletRequest request, HttpServletResponse response) {
		
		List<ReimbursementPOJO> reimbursements = rDao.findAll();
		
		return reimbursements;
		
	}
	
	public static ReimbursementPOJO updateReimb(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementPOJO reimbursement = new ReimbursementPOJO();
		
		try {
			 reimbursement = mapper.readValue(request.getReader(), ReimbursementPOJO.class);
		} catch (IOException ioe) {
		
		}
		
		rDao.updateReimb(reimbursement.getReimb_id(), reimbursement.getResolver_id(), reimbursement.getReimb_status_id());
		return reimbursement;
	}
	
	public static List<ReimbursementPOJO> getReimbSort(HttpServletRequest request, HttpServletResponse response) {
		EmployeeRolesPOJO param = null;
		int i = 0;
		String param2 = null;
		
		try {
			
			param = mapper.readValue(request.getReader(), EmployeeRolesPOJO.class);
			i = param.getEmp_role_id();

		} catch (IOException ioe) {
		
		}
		
		switch(i) {
		case 1:
			param2 = "reimb_amount";
			break;
		case 2:
			param2 = "reimb_submitted";
			break;
		case 3:
			param2 = "reimb_resolved";
			break;
		case 4:
			param2 = "reimb_author";
			break;
		case 5:
			param2 = "reimb_resolver";
			break;
		case 6:
			param2 = "reimb_status_id";
			break;
		case 7: 
			param2 = "reimb_type_id";
			break;
		default:
			param2 = "reimb_id";
			break;
		}
		
		List<ReimbursementPOJO> reimbursementssorted = rDao.reimbSort(param2);

		return reimbursementssorted;
	}
	
	public static List<ReimbursementPOJO> findReimbByIdSort(HttpServletRequest request, HttpServletResponse response) {
		EmployeePOJO employee = null;
		String param2;
		int i = 0;
		
		try {
			employee = mapper.readValue(request.getReader(), EmployeePOJO.class);
			i = employee.getUser_role_id();
		} catch (IOException ioe) {
		
		}
		
		switch(i) {
		case 1:
			param2 = "reimb_amount";
			break;
		case 2:
			param2 = "reimb_submitted";
			break;
		case 3:
			param2 = "reimb_resolved";
			break;
		case 4:
			param2 = "reimb_author";
			break;
		case 5:
			param2 = "reimb_resolver";
			break;
		case 6:
			param2 = "reimb_status_id";
			break;
		case 7: 
			param2 = "reimb_type_id";
			break;
		default:
			param2 = "reimb_id";
			break;
		}
		
		List<ReimbursementPOJO> reimbursementssorted = rDao.findBySomeParamSort(employee.getEmp_id(), param2);

		return reimbursementssorted;
	}
	
}
