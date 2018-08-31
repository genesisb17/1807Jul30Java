package com.rev.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class connectionFactory {
	/*
	 * 
	 * Class used to establish a connection with database
	 * Uses lazy singleton design pattern as to return same single
	 * connection each time one is requested.
	 * 
	 * In order to establish a connection, we need 4 things
	 * :Driver,URL(location of database), username,password
	 */
	
  private static connectionFactory cf=null;
  private static Boolean build=true;
  
  private connectionFactory() {
	  build=false;
	  
  }
  
  public static synchronized connectionFactory getInstance() {
	  if(build=true) cf=new connectionFactory();
	  return cf;
  }
  public Connection getConnection() {
	  
	  Connection conn=null;//will instantiate in a try block
	  Properties prop=new Properties();
	  
	  String path="C:\\mm\\1807Jul30Java\\Michael_Davis_Code\\bookstore-jdbc\\src\\main\\resources\\application.properties";
	  
	  try {
		 prop.load(new FileReader(path));
		  Class.forName(prop.getProperty("driver"));
		  
		 
		 conn=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("usr"),prop.getProperty("pwd"));
		  
		  
		  //HARD CODE to force it to work
		 // Class.forName("oracle.jdbc.driver.OracleDriver");
		//  conn=DriverManager.getConnection("jdbc:oracle:thin:@mdavisdb.casvmhchbrk0.us-east-1.rds.amazonaws.com:1521/ORCL", "mdavisdb", "password!");
	  }
	  
	 
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  
	  return conn;
  }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
