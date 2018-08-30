package com.ex.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.dao.UserDao;
import com.ex.dao.UserDaoImp;
import com.ex.pojos.Reimbursement;
import com.ex.pojos.RequestForm;
import com.ex.pojos.User;
import com.ex.pojos.UserInformation;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserServices {
	
	private static UserDao userDao = UserDaoImp.getInstance();
	
	public static UserInformation login(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		
		try {
			user = mapper.readValue(request.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		User authorized = userDao.getUser(user.getUsername());
		if (userDao.getPasswordHash(user).equals(authorized.getPassword()))
			return userDao.getUserInformation(user.getUsername());
		return null;
	}
	
	public static List<Reimbursement> employeeTable(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		
		try {
			user = mapper.readValue(request.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return userDao.getEmpTables(user.getUsername());
	}

	public static int submitRequest(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		RequestForm requestForm = null;
		
		try {
			requestForm = mapper.readValue(request.getReader(), RequestForm.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return userDao.submitRequest(requestForm);
	}

}
