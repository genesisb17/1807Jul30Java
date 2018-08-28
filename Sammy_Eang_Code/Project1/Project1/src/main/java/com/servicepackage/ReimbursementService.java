package com.servicepackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ReimbursementDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.EmployeePOJO;
import com.pojo.ReimbursementPOJO;
import com.pojo.ReimbursementStatusPOJO;
import com.pojo.ReimbursementTypePOJO;

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
	
	//Less useful daos for finding type and status
	public static List<ReimbursementStatusPOJO> getAllStatuses(HttpServletRequest request, HttpServletResponse response) {
		
		List<ReimbursementStatusPOJO> statuses = rDao.getAllStatus();
		
		return statuses;
	}
	
	public static List<ReimbursementTypePOJO> getAllTypes(HttpServletRequest request, HttpServletResponse response) {
		
		List<ReimbursementTypePOJO> types = rDao.getAllTypes();
		
		return types;
	}
	
	
	
}
