package com.ex.services;

import java.util.List;

import com.ex.dao.ReimbursementDao;
import com.ex.pojos.Reimbursement;

public class ReimbursementServices {

	public List<Reimbursement> getAll(int Userid) {
		return ReimbursementDao.getAllReimbursements(Userid);
	}

}
