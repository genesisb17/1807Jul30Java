package com.servicepackage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.dao.EmployeeDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.EmployeePOJO;
import com.pojo.JWTHeader;
import com.pojo.JWTPayload;

public class EmployeeService {

	static EmployeeDAO eDao = new EmployeeDAO();
	static ObjectMapper mapper = new ObjectMapper();
	
	static JWTHeader loginJwtHeader = null;
	static JWTPayload loginJwtPayload = null;
	
	public static EmployeePOJO login(HttpServletRequest request, HttpServletResponse response) {
		
		//EmployeePOJO employee = null;
		
		JWTHeader authJwtHeader = new JWTHeader();
		authJwtHeader.setTyp("JWT");
		authJwtHeader.setAlg("sha512");
		String authorizedSecret = "come and get some recipes!";
		
		EmployeePOJO authorized = eDao.findOneByUname(loginJwtPayload.getUsername());
		
		try {
			//encodes header of authorized
			String authHeaderTypEncode = Base64.getEncoder().encodeToString(authJwtHeader.getTyp().getBytes("utf-8"));
			String authHeaderAlgEncode = Base64.getEncoder().encodeToString(authJwtHeader.getAlg().getBytes("utf-8"));
			System.out.println("Authorized Header Encode: " + authHeaderTypEncode + " " + authHeaderAlgEncode);
			
			//encodes header of login
			String loginHeaderTypEncode = Base64.getEncoder().encodeToString(loginJwtHeader.getTyp().getBytes("utf-8"));
			String loginHeaderAlgEncode = Base64.getEncoder().encodeToString(loginJwtHeader.getAlg().getBytes("utf-8"));
			System.out.println("Login Header Encode: " + loginHeaderTypEncode + " " + loginHeaderAlgEncode);
			
			//encodes login payload. AKA encodes credentials of user trying to login.
			String loginuname = Base64.getEncoder().encodeToString(loginJwtPayload.getUsername().getBytes("utf-8"));
			String loginpw = Base64.getEncoder().encodeToString(loginJwtPayload.getPw().getBytes("utf-8"));
			System.out.println("Login Payload : " + loginuname + " " + loginpw);
			
			//encodes authorized payload. AKA encodes credentials of official user in db with matching name.
			String authorizeduname = Base64.getEncoder().encodeToString(authorized.getUsername().getBytes("utf-8"));
			String authorizedpw = Base64.getEncoder().encodeToString(authorized.getPw().getBytes("utf-8"));
			System.out.println("Auhtorized Payload : " + authorizeduname + " " + authorizedpw);
			
			//combines encoded strings of header and user
			String logindata = loginHeaderTypEncode + loginHeaderAlgEncode + "." + loginuname + loginpw;
			String authorizeddata = authHeaderTypEncode + authHeaderAlgEncode + "." + authorizeduname + authorizedpw;
			System.out.println("Encoded data login: " + logindata);
			System.out.println("Encoded data authorized: " + authorizeddata);
			
			//hashes encoded login/user with secret
			//*****make sure to change secret in login to received from angular object
			String hashedlogin = calcSha(loginJwtPayload.getSecret(), logindata);
			String hashedauthorized = calcSha(authorizedSecret, authorizeddata);
			System.out.println("Hashed Login: " + hashedlogin);
			System.out.println("Hashed Authorized: " + hashedauthorized);
			
			//encodes hash
			String loginsignature = Base64.getEncoder().encodeToString(hashedlogin.getBytes("utf-8"));
			String authorizedsignature = Base64.getEncoder().encodeToString(hashedauthorized.getBytes("utf-8"));
			System.out.println("Login Signature: " + loginsignature);
			System.out.println("Authorized Signature" + authorizedsignature);
			
			//checks if they're the same
			if(loginsignature.equals(authorizedsignature)) {
				System.out.println("TRUE");
				return eDao.findOneByUname(authorized.getUsername());
			} else {
				System.out.println("false");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
//		if (employee.getPw().equals(authorized.getPw())) {
//			return eDao.findOneByUname(employee.getUsername());
//		}
		
		return null;
	}
	
	public static JWTHeader loginJwtHeader(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			loginJwtHeader = mapper.readValue(request.getReader(), JWTHeader.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(loginJwtHeader.getTyp() + loginJwtHeader.getAlg());
		
		return null;
	}
	
	public static JWTPayload loginJwtPayload(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			loginJwtPayload = mapper.readValue(request.getReader(), JWTPayload.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(loginJwtPayload.getUsername() + loginJwtPayload.getPw() + loginJwtPayload.getSecret());
		return null;
	}
	
	//hashes the data
	public static String calcSha(String secret, String data) {
	    return DigestUtils.sha512Hex(secret + data);
	}
	
	public static List<EmployeePOJO> getAllEmp(HttpServletRequest request, HttpServletResponse response) {
		List<EmployeePOJO> employees = eDao.findAll();
		
		return employees;
	}

}
