package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.ers_reimbursementDAO;
import com.ex.pojos.ers_reimbursement;

public class ers_reimbursementService 
{
	static DAO<ers_reimbursement, Integer> aDao = new ers_reimbursementDAO();

	public List<ers_reimbursement> getAll()
	{
		return aDao.getAll();
	}
	
	public List<ers_reimbursement> getEmployeeReim(String obj)
	{
		int id = Integer.parseInt(obj);
		
		List<ers_reimbursement> unfiltered = aDao.getAll();
		
		List<ers_reimbursement> filtered = new ArrayList<ers_reimbursement>();
		
		for(ers_reimbursement ers: unfiltered)
		{
			if (ers.getReimb_author() == id)
			{
				filtered.add(ers);
			}
		}
		
		return filtered;
	}
	
	public void saving(String[] userInformation)
	{
		ers_reimbursement newReim = new ers_reimbursement();
		String amount = userInformation[0];
		String description = userInformation[1];
		//String reimb_receipt = userInformation[2];
		String author = userInformation[2];
		String typeId = userInformation[3];
		
		if(!amount.equals("") && !description.equals("") && !author.equals("") && !typeId.equals(""))
		{
			//System.out.println(amount + " " + description + " " + author + " " + typeId);
			newReim.setReimb_amount(Double.parseDouble(amount));
			newReim.setReimb_description(description);
			newReim.setReimb_author(Integer.parseInt(author));
			newReim.setReimb_type_id(Integer.parseInt(typeId));
			
			aDao.save(newReim);
			
		}
	}
	
	public ers_reimbursement update(int[] obj)
	{
		ers_reimbursement ers = new ers_reimbursement();
		
		ers.setReimb_id(obj[0]);
		ers.setReimb_resolver(obj[1]);
		ers.setReimb_status_id(obj[2]);		
		
		return aDao.update(ers);
	}
	
}
