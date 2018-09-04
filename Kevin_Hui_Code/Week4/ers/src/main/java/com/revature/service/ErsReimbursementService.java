package com.revature.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ErsReimbursementDao;
import com.revature.pojo.ErsReimbursement;
import com.revature.pojo.ErsUser;

public class ErsReimbursementService {
	static ErsReimbursementDao rd = new ErsReimbursementDao();

	public ErsReimbursement addErsReimbursement(ErsReimbursement r) {

		return rd.insert(r);
	}

	public static List<ErsReimbursement> getReimbursementsByUser(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession httpSession = request.getSession(false);
		// False because we do not want it to create a new session if it does not exist.
		ErsUser user = null;
		if (httpSession != null) {
			user = (ErsUser) httpSession.getAttribute("user");
		}

		if (user == null) {
			System.out.println("user still missing");
			return null;
		}

		ObjectMapper mapper = new ObjectMapper();
		System.out.println("getting user in reimb_service: " + user);
		try {
			user = mapper.readValue(request.getReader(), ErsUser.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (rd.findByUserId(user.getUsername()));

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
