package com.rev.dao;

public interface DAO {
	
	boolean doesAccountExist();
	boolean createAccount();
	boolean withdraw();
	boolean deposit();
	
}
