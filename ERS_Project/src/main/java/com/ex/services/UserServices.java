package com.ex.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.dao.UserDao;
import com.ex.dao.UserDaoImp;
import com.ex.pojos.Reimbursement;
import com.ex.pojos.RequestForm;
import com.ex.pojos.UpdateForm;
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
		if (userDao.getPasswordHash(user).equals(authorized.getPassword())) {
			UserInformation temp = userDao.getUserInformation((user.getUsername()));
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", temp);
			return temp;
		}
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
	
	public static List<Reimbursement> allTable(HttpServletRequest request, HttpServletResponse response) {
		return userDao.getAllTables();
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

	public static Object sessionCheck(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		return session.getAttribute("userinfo");
	}

	public static Object logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return null;
	}
	
	public static Object updateTable(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		UpdateForm updateForm = null;
		
		try {
			updateForm = mapper.readValue(request.getReader(),UpdateForm.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return userDao.updateForm(updateForm);
	}

}
