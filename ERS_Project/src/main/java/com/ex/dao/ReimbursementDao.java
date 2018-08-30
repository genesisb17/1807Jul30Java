package com.ex.dao;

import java.util.ArrayList;

import com.ex.pojos.Reimbursement;

public interface ReimbursementDao {
	
	ArrayList<Reimbursement> getEmpTables(String username);

}
