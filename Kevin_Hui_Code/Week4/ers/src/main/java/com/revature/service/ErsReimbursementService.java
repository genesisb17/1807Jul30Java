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

	public static List<ErsReimbursement> getReimbursementsByUser(HttpServletRequest request, HttpServletResponse response) {

		ObjectMapper mapper = new ObjectMapper();
		ErsUser user = (ErsUser) request.getSession().getAttribute("user");
		System.out.println(request.getSession().getAttribute("user"));
		try {
			user = mapper.readValue(request.getReader(), ErsUser.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (rd.findByUserId(user.getUsername()));

	}

	public static List<ErsReimbursement> getAllReimbursements(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			mapper.readValue(request.getReader(), ErsReimbursement.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rd.findAll();

	}

	public static ErsReimbursement submitErsReimbursement(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		ErsReimbursement reimb = null;
		try {
			reimb = mapper.readValue(request.getReader(), ErsReimbursement.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		rd.insert(reimb);
		return reimb;

	}
}
