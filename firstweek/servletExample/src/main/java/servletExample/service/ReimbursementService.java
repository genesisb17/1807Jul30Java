package servletExample.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import servletExample.dao.ReimbursementDao;
import servletExample.pojo.NewReim;
import servletExample.pojo.Reimbursement;
import servletExample.pojo.UserInfo;

public class ReimbursementService {
	private static ReimbursementDao rd = ReimbursementDao.getInstance();
	public static List<Reimbursement> reimHistory(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		ObjectMapper mapper = new ObjectMapper();
		
		Reimbursement reim = null;
		List<Reimbursement> r = new ArrayList<Reimbursement>();
		UserInfo u = (UserInfo) session.getAttribute("user");
		r.addAll(rd.getUserReimbursements(u));
//		System.out.println(r.size());
		return r;
		
		
		
	}
	
	public static List<Reimbursement> allHistory(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		ObjectMapper mapper = new ObjectMapper();
		
		Reimbursement reim = null;
		List<Reimbursement> r = new ArrayList<Reimbursement>();
		UserInfo u = (UserInfo) session.getAttribute("user");
		r.addAll(rd.getAllReimbursements());
//		System.out.println(r.size());
		return r;
		
		
		
	}
	public static Object createReim(HttpServletRequest req, HttpServletResponse resp) {
		ObjectMapper mapper = new ObjectMapper();
		
		Reimbursement reim = null;
		try {
			
			reim = mapper.readValue(req.getReader(), Reimbursement.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rd.addReimbursement(reim);
		return null;
	}
	
	public static Object updateReim(HttpServletRequest req, HttpServletResponse resp) {
		ObjectMapper mapper = new ObjectMapper();
		
		NewReim nr = null;
		try {
			
			nr = mapper.readValue(req.getReader(), NewReim.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rd.evalReimbursement(nr);
		return null;
	}
}
