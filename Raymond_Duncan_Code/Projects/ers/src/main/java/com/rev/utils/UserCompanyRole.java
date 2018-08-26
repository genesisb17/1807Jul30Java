package com.rev.utils;

public enum UserCompanyRole {
	
	ADMIN, 		//Database Admin
	CEO, 		//Chief Executive Officer
	CTO, 		//Chief Technology Officer
	COO, 		//Chief of Outreach
	OPS_HEAD,	//Head of Operations
	MANAGER,	//Regular Manager Role
	ASSOCIATE;	//Regular Employee Role
	
	private static UserCompanyRole[] companyRoles = UserCompanyRole.values();
	
	public static String fromInt(int i) {
		return companyRoles[i].toString();
	}

}
