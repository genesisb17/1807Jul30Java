package com.revature.raysbank;

import com.revature.dao.TransactionDAO;

/**
 * Hello world!
 *
 */
public class App 
{
	static final TransactionDAO transactionDAO= new TransactionDAO();
    public static void main(String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
