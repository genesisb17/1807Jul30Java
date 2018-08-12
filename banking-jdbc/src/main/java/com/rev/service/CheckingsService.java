package com.rev.service;

import com.rev.dao.CheckingsDAO;
import com.rev.pojos.Checkings;
import com.rev.pojos.Users;

public class CheckingsService {
	
	private static CheckingsDAO CheckingsDAO = new CheckingsDAO();

	public static Checkings doesAccountExist(Users user) {
		return CheckingsDAO.doesAccountExist(user);
	}

	public static void total(Checkings account) {
		double total = account.getTotal();
		System.out.println("The amount in your account is $" + total);
		System.out.println("Thank you for for using the Not Greedy Banking App!");
		System.exit(0);
	}
}
