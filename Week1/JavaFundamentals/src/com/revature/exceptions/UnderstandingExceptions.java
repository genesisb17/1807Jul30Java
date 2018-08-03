package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class UnderstandingExceptions {

		public static void main(String[] args) {
			try {
				System.out.println(args[0].toLowerCase()); //You'll see a stack trace for an exception at line 6 if no input is passed
				throw new IOException(); //allows you to throw an exception at this
			} catch(IOException e) {
				e.printStackTrace();
				System.out.println("Caught IOE");
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				System.out.println("Caught AIOOBE");
			} catch(Exception e) {
				System.out.println("More catching");
			}
			
			System.out.println("Reached end of first risky code!");
			
			try {
				propagate();
			} catch (MyException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception message: " + e.getMessage());
			}
			
			//if you throw a new exception, you can use the throws keyword after the method signature to handle it
		}
		
		static void exploreStack(String[] args) throws IOException {
			System.out.println("About to throw new Exception from exploreStack");
			String file = "test.txt";
			FileWriter write = new FileWriter(file);
		}
		
		static void throwingCustom(String issue) throws MyException {
			String message = "This is our problem" + issue;
			//try {
				throw new MyException(message);
			//} catch (MyException e) {
			//	e.printStackTrace();
			//}
		}
		
		//Exceptions will only happen if you have risky code or throw it yourself.
		
		static void propagate() throws MyException{
			throwingCustom("In propagate method, calling method that throws an exception");
		}
}


