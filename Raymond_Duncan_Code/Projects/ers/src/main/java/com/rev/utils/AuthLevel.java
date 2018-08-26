package com.rev.utils;

import com.rev.pojos.User;

public enum AuthLevel {

	ADMIN, MANAGER, EMPLOYEE;

	public static AuthLevel getAuthLevel(User u) {
		switch(u.getCompanyRole()) {
		case "ADMIN":
			return AuthLevel.ADMIN;
		case "MANAGER":
			return AuthLevel.MANAGER;
		default:
			return AuthLevel.EMPLOYEE;
		}
	}
}
