package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class UnderstandingExceptions {


	public static void main(String[] args) {



		try {
			exploreStack(args);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Catching exception e in main method");
		}

		System.out.println("Reached the end of first risky code block");
		
		try {
		propagate();
		}
		catch(MyException e) {
			System.out.println("EXCEPTION MESSAGE: " + e.getMessage());
		}
		
	}


	static void doThings(String[] args) {
		System.out.println("IN DO THINGS METHOD BEFORE TRY CATCH");
		try { //MUST use either a catch, finally, or both
			System.out.println(args[5].toLowerCase());
			throw new IOException(); //allow you to throw an exception at this line of code
		}
		catch(Exception e) {
			System.out.println("general backup behavior");
			e.printStackTrace();
			if(e instanceof IOException) {
				System.out.println("IO");
			}
			else if(e instanceof ArrayIndexOutOfBoundsException) {
				System.out.println("AIIIB");
			}
		}
	/*	catch(IOException e) {
			System.out.println("Caught IOE");
			System.out.println("doing things specific to io");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Caught AIOOBE");
			System.out.println("doing something to fix my index");
		} */

		System.out.println("IN DO THINGS AFTER TRY CATCH");
	}

	static void exploreStack(String[] args) throws IOException{ //goes after method signature; indicates that this method will throw this exception and calling method must "handle" it 
		doThings(args);
		System.out.println("About to throw new Exception from explore stack");
		String file = "test.txt";
		FileWriter write = new FileWriter(file);
	}
	
	static void throwingCustom(String issue) throws MyException {
		String message = "This is our problem: " + issue;
		throw new MyException(message);
	}
	
	static void propagate() throws MyException {
		throwingCustom("In propagate method, calling method that throws an exception");
	}
	
	

}
