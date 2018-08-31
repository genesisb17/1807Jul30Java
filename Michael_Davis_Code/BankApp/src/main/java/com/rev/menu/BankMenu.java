package com.rev.menu;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


import com.rev.util.connectionFactory;

public class BankMenu {
	private static String currentUser=null;
	private static String userPassword=null;
	private String holder;
	private static int currentUserId;
	private static ArrayList<Account> AccList=new ArrayList<Account>();
	private static ArrayList<User> UserList;
	static Scanner keyboard=new Scanner(System.in);
	private static int userID;
	
	public static void startMenu() {
		String response;
		
		System.out.println("Welcome to Mike's Bank. Are you already banking with us(Type No if creating a new User account)");
		System.out.println("Type Yes or No");
		response=keyboard.nextLine();
		
		if(response.equalsIgnoreCase("YES")) {
			setLogin();
		}
		
		else if(response.equalsIgnoreCase("NO")) {
			createUser();
		}
		else startMenu();
		
		
		
	}
	
	public static void createUser() {
		String firstname="";
		String lastname="";
		String email="";
		String phone="";
		String username="";
		String password="";
		String password2="";
		Boolean c=false;
		Boolean pwdMatch=false;
		
		System.out.println("Enter your First Name");
		firstname=keyboard.next();
		
		System.out.println("Enter your Last Name");
		lastname=keyboard.next();
		System.out.println("Enter your current Email Address");
		email=keyboard.next();
		if((email.contains("@"))&&(email.contains("."))){
			c=true;
		}
		while(c==false) {
			System.out.println("invalid email address. Please Re-Enter a valid email");
			email=keyboard.next();
			
			if((email.contains("@"))&&(email.contains("."))){
				c=true;
			}
			
		}
		
		System.out.println("Enter your phone number");
		phone=keyboard.next();
		
		System.out.println("Enter your desired username");
		username=keyboard.next();
		
		while(isUserTaken(username)==true) {
			System.out.println("Sorry that Username is taken.Please Enter a different one");
			username=keyboard.next();
		}
		//going to have to already have logic here to check if username is already taken
		//can put up at the top and store 
	
		//while(pwdMatch=false) {
		System.out.println("Enter a Password for your account");
		password=keyboard.next();
		System.out.println("Re enter your password");
		password2=keyboard.next();
		
		if(!password.equals(password2)){
			System.out.println("Passwords did not match.");
		while(!password.equals(password2)) {
			System.out.println("Enter a Password for your account");
			password=keyboard.next();
			System.out.println("Re enter your password");
			password2=keyboard.next();
		}
			
		}
		
		//if (password.equals(password2)) {pwdMatch=true;}
		//}
		
		String insertQuery="Insert into USERS(F_name,l_name,email,phone,username,User_Password)  values(?,?,?,?,?,?)";
		try(Connection conn= connectionFactory.getInstance().getConnection()){
			PreparedStatement prep=conn.prepareStatement(insertQuery);
			 
			prep.setString(1,firstname);
			prep.setString(2,lastname);
			prep.setString(3,email);
			prep.setString(4,phone);
			prep.setString(5,username);
			prep.setString(6,password);
			prep.executeQuery();
			System.out.println("Sucess!");
			
			currentUser=username;
			userPassword=password;
			
			displayUserOptions();
		}
		
		catch(Exception e){
			System.out.println("Name unavailible");
			e.printStackTrace();
		}
		
		
		/*
		 * then either set curent user login variables or return them to login
		 * method to do it themselves
		 */
		
		
	}
	public static void setLogin() {
		String usr;
		String pwd;
		
		System.out.println("Please enter your Username");
		usr=keyboard.next();
		
		if(usr.length()>20) { 
			System.out.println("Invalid Username");
			setLogin();}
		System.out.println("Please enter your password");
		pwd=keyboard.next();
		
		
		
		int count=0;
		try(Connection conn= connectionFactory.getInstance().getConnection()){
			String query="select * from Users where USERNAME='"+usr+"'and User_Password= '"+pwd+"'";
			
			Statement statement=conn.createStatement();
			ResultSet rs=statement.executeQuery(query);
			if(rs.next()) {
				currentUser=rs.getString(6);
				userPassword=rs.getString(7);
				currentUserId=rs.getInt(1);
				count+=1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Could not login this User");
		}
		
		if(count<1) {
			System.out.println("User name and password combination does not exist.");
			setLogin();
		}
		else displayUserOptions();
		
		//ADD LOGIN TO CHECK FOR MATCHING INFO IN DB
		
		//if succesful set class variables for currentUSER, and userPassword
		
		if(currentUser!=null) {
			displayUserOptions();
		}
		else setLogin();
		
		
	}
	
	public static void displayUserOptions() {
		
		//listCurrentUserAccounts(currentUserId);
		int respon;
		System.out.println("You are logged in as "+currentUser);
		System.out.println("Enter 1 to view Your current accounts");
		System.out.println("Enter 2 if you would like to make a Withdrawl");
		System.out.println("Enter 3 if you would like to make a Deposit");
		System.out.println("Enter 4 to logout");
		System.out.println("Enter 5 to Open a new Checkings or Savings Account");
		System.out.println("Enter 6 if you would like to delete one of your accounts");
		
		respon=keyboard.nextInt();
		
		if (respon==1) {
			listCurrentUserAccounts(currentUserId);
			for(Account a:AccList) {
				System.out.println(a.toString());
			}
			displayUserOptions();
			//displayUserOptions();
			//MethodFinished- will list the current logged in users accounts
			//also creates a list of accounts to be referenced later if need be for current user
		}
		if (respon==2) {
			Withdrawl();
			//Method  FINISHED
		}
		if (respon==3) {
			Deposit();
			//Method NOT FINISHED
		}
		if (respon==4) {
			currentUser=null;
			userPassword=null;
			AccList.clear();
			startMenu();
			//METHOD FINISHED
		}
		
		if (respon==5) {
			newAccount(currentUserId);
			//METHOD FINISHED
		}
		if (respon==6) {
			deleteAccount(currentUserId);
			//METHOD FINISHED
		}
		
	}
	private static void newAccount(int currentUserID) {
		int type;
		String type2="";
		boolean good=false;
		int g=(int) ((Math.random() *99999999)+100000000);
		
	
		System.out.println("Type 1 for a checkings account or Type 2 to make a Savings Account");
		type=keyboard.nextInt();
		if(type>2) {
			System.out.println("I said 1 or 2 LISTEN");
			newAccount(currentUserID);
		}
		if(type==1)type2="Checkings";
		if(type==2)type2="Savings";
		
		
		//after making a chose here we create a new bank account with a balance of 0 
		//with the chosen type of account from user
		//while(good=false) {
		String insertQuery="Insert into Accounts(Acc_Owner,Acc_number,Acc_type,Acc_Balance)  values(?,?,?,?)";
		try(Connection conn= connectionFactory.getInstance().getConnection()){
			
			PreparedStatement prep=conn.prepareStatement(insertQuery);
			prep.setInt(1,currentUserId);
			prep.setInt(2,g);
			prep.setString(3,type2);
			prep.setInt(4,0);
			prep.executeQuery();
			System.out.println("Sucessfully added account!");
			good=true;
			//displayUserOptions();
		}
		
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Try Again");
			displayUserOptions();
		}
		
		//}
	}

	private static void deleteAccount(int currentUserId) {
		int chosenAccz;
		String resp;
		
		//System.out.println(listCurrentUserAccounts(currentUserId).toString());
		System.out.println("Enter the acct id of the account you wish to Delete");
		chosenAccz=keyboard.nextInt();
		System.out.println("Warning it was your responsibility to withdraw your money before closing an account");
		System.out.println("Unclaimed funds must be collected in person at one of our locations.");
	System.out.println("Are you sure you want to continue? (Y/N)");
	resp=keyboard.next();
	
	if(resp.equalsIgnoreCase("Y")) {
		
		String deleteQuery="Delete from Accounts where Acc_ID='"+chosenAccz+"' and Acc_owner='"+currentUserId+"'";
		try(Connection conn= connectionFactory.getInstance().getConnection()){
			PreparedStatement prep=conn.prepareStatement(deleteQuery);
			prep.executeQuery();
			System.out.println("Sucessful Deletion");
			displayUserOptions();
		}
		catch(Exception e) {
			System.out.println("Could not delete user? are you trying to delete someone elses account?");
			e.printStackTrace();
			
		}
		
		
		
		//add delete statement for account matching entered account number
	}
	else {
		System.out.println("Good Choice");
		displayUserOptions();
	}
	}
	

	private static void Deposit() {
		
		int chosenAcc;
		double depositAmount;
		//listCurrentUserAccounts(currentUserId);
		System.out.println("Enter the acct id of the account you wish to Deposit into.");
		chosenAcc=keyboard.nextInt();
		System.out.println("Please enter the amount of money You are depositing");
		depositAmount=keyboard.nextDouble();
		
		double b=0;
		double newb=0;
		int ad=0;
		
		for(Account a:AccList) {
			if(a.getAccID()==chosenAcc) {
				b=a.getBalance();
				ad=a.getAccID();
			}
		
			newb=b+depositAmount;
			
				
			}
		
			try(Connection conn= connectionFactory.getInstance().getConnection()){
				String query="Update Accounts set Acc_Balance='"+newb+"' where Acc_ID='"+ad+"'";
				PreparedStatement prep=conn.prepareStatement(query);
				prep.executeQuery();
				System.out.println(" You Succesfuly  Deposited $"+depositAmount);
				displayUserOptions();
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Could not make Deposit");
				Deposit();
			}
		
		
		
		/*
		 * 
		 Add logic to insert chosen deposit amount into acct with matching acc ID
		 */
	}

	private static void Withdrawl() {
		int chosenAcc1;
		double withdrawAmount1;
		//listCurrentUserAccounts(currentUserId);
		System.out.println("Enter the acct id of the account you wish to Withdraw From.");
		chosenAcc1=keyboard.nextInt();
		System.out.println("Please enter the amount of money you wish to withdraw");
		withdrawAmount1=keyboard.nextDouble();
				
	double b=0;
	double newb=0;
	int ad=0;
	
	for(Account a:AccList) {
		if(a.getAccID()==chosenAcc1) {
			b=a.getBalance();
			ad=a.getAccID();
		if(a.getBalance()<withdrawAmount1) {
			
			System.out.println("Sorry your balance is not high enough to Withdraw that Amount.");
					Withdrawl();
		}
		else newb=b-withdrawAmount1;
		}
			
		}
	
		try(Connection conn= connectionFactory.getInstance().getConnection()){
			String query="Update Accounts set Acc_Balance='"+newb+"' where Acc_ID='"+ad+"'";
			PreparedStatement prep=conn.prepareStatement(query);
			prep.executeQuery();
			System.out.println("Succesfull withdrew $"+withdrawAmount1);
			displayUserOptions();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Could not make withdrawl");
		}
		
		
		
		
		}
	
		/*
		 * add logic here to check chosen withdrawl amount with balance of account selected from 
		 * db with the acct id that matches
		 */
	private static boolean isUserTaken(String uname) {
		int count=0;
		try(Connection conn= connectionFactory.getInstance().getConnection()){
			String query="select * from Users where USERNAME='"+uname+"'";
			
			
			//STATEMENT INTERFACE
			Statement statement=conn.createStatement();
			ResultSet rs=statement.executeQuery(query);
			if(rs.next()) {
				count+=1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if (count>0)return true;
		else return false;
		
		
	}

	private static ArrayList<Account> listCurrentUserAccounts(int currentUserID) {	
		try(Connection conn= connectionFactory.getInstance().getConnection()){
			String query="select * from ACCOUNTS where Acc_Owner="+currentUserID;
			Statement statement=conn.createStatement();
			ResultSet rs=statement.executeQuery(query);
			
			while(rs.next()) {
				//iterate through rows of set
				Account temp=new Account();
				
				temp.setAccID(rs.getInt(1));
				temp.setAccType(rs.getString(4));
				temp.setAccNumber(rs.getInt(3));
				temp.setOwner(rs.getInt(2));
				temp.setBalance(rs.getDouble(5));
				
				AccList.add(temp);
				//System.out.println("Inside the loop");
				//System.out.println(temp.toString());
			}	
	}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return AccList;
		
	}
	
	
	public void currentClients() {
		//"{call getEmployee(?,?,?,?,?)}"
		
		
		try(Connection conn= connectionFactory.getInstance().getConnection()){
			String query="{call currentClients(?)}";
			Statement statement=conn.createStatement();
			ResultSet rs=statement.executeQuery(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		startMenu();
		/*
		for(Account a:g) {
			System.out.println(a.toString());
			
		}
		*/

	}

}
