package com.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.bank.app.Driver;
import com.bank.dao.AccountDao;
import com.bank.dao.AccountTypeDao;
import com.bank.dao.UserDao;
import com.bank.pojo.Account;
import com.bank.pojo.AccountType;
import com.bank.pojo.User;

public class Service {
	
	static AccountType at = new AccountType();
	static AccountTypeDao atd = new AccountTypeDao();
	static Account a = new Account();
	static AccountDao ad = new AccountDao();
	static UserDao ud = new UserDao();
	static User u = new User();
	
	public static void wrngLgn() {
		
	}
	
	//Prints out the types of accounts a
	public static void onOpenAccount() {
		List<AccountType> at = atd.typesOfAccounts();
		for(AccountType a : at) {
		System.out.println(a.toString());
		}
		
		
	}
	
	//Used to display user accounts after they are logged in
	public static void onLoginAfter(String uname) {
		
		User users = ud.findOneAfter(uname);
		System.out.println(users.getName());
	
		List<Account> uaccts = ad.findAccounts(uname);
		for(Account a : uaccts) {
		System.out.println(a.toString());
		}
		Driver.userOptions();
	}	
	//Used to display accounts on the initial login
	public static User onLogin(String uname, String pwd) throws SQLException {
		
			User users = ud.findOne(uname, pwd);
			if (users==null) {
				System.out.println("Could not find any accounts that match those credentials");
				Driver.welcomeMessage();
			}
//			if (users == null) {
//				throw new SQLException();
//			}
			
			
			System.out.println(users.getName());
			
			List<Account> uaccts = ad.findAccounts(uname);
			for(Account a : uaccts) {
			System.out.println(a.toString());
			}
			return users;
	}
	public static void onDelete(String uname, String pwd) throws SQLException {
		
		ud.deleteOne(uname, pwd);
		
	}
	public static void onWithdraw(int aid, int amt) throws SQLException {
		
		ad.withdraw(aid, amt);
		
	}
	public static void onDeposit(int aid, int amt) throws SQLException {
		
		ad.deposit(aid, amt);
		
	}
	
	public static List<Account> getTime() {
		
		List<Account> uaccts = ad.getTime();
		for(Account a : uaccts) {
		System.out.println(a.getTime());
		}
		return uaccts;
	}	
	
}

