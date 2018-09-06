package com.revature.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ErsReimbursementDao;
import com.revature.pojo.ErsReimbursement;
import com.revature.pojo.ErsUser;

public class ErsReimbursementService {
	static ErsReimbursementDao rd = new ErsReimbursementDao();

	public ErsReimbursement addErsReimbursement(ErsReimbursement r) {

		return rd.insert(r);
	}

	public static List<ErsReimbursement> getReimbursementsByUsername(HttpServletRequest request,
			HttpServletResponse response) {

		ErsUser user = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			user = mapper.readValue(request.getReader(), ErsUser.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (rd.findByUsername(user.getUsername()));

	}

	public static List<ErsReimbursement> getAllReimbursements(HttpServletRequest request,
			HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			mapper.readValue(request.getReader(), ErsReimbursement.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rd.findAll();

	}

	public static ErsReimbursement addReimbursement(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		ErsReimbursement reimb = null;
		try {
			reimb = mapper.readValue(request.getReader(), ErsReimbursement.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rd.insert(reimb);

	}
	
	public static void approveReimbursement(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		ErsReimbursement reimb = null;
		try {
			reimb = mapper.readValue(request.getReader(), ErsReimbursement.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		rd.approveReimbursement(reimb);

	}
	
	public static void denyReimbursement(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		ErsReimbursement reimb = null;
		try {
			reimb = mapper.readValue(request.getReader(), ErsReimbursement.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		rd.denyReimbursement(reimb);

	}

	public static Object getReimbursementsByUserId(HttpServletRequest request, HttpServletResponse response) {
		ErsUser user = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			user = mapper.readValue(request.getReader(), ErsUser.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(user);
		return (rd.findByUserId(user.getUserId()));
	}
}
