package exceptions;

import java.io.IOException;

public class UnderstandingExceptions {

	public static void main(String[] args) {

		try {
			exploreStack(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Reached the end of first riskky code block");
		
		try {
			propagate();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}

	}
	
	static void doThings(String[] args) {
		try { //MUST either be a catch, finally, or both
			System.out.println(args[0].toLowerCase());
			throw new IOException(); //allow you to throw an exception
		}
		catch(IOException e) {
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("caught AIOOBE");
		}
	}
	 //goes after method signature; indicates that this method will throw 
	//this exception and calling must handle it
	static void exploreStack(String[] args) throws Exception {
		doThings(args);
		throw new Exception();
	}
	
	static void throwingCustom(String issue) throws MyException {
		String message = "This is our problem: " + issue;
		throw new MyException(message);
		//System.out.println(x);
	}
	
	static void propagate() throws MyException {
		throwingCustom("In progagate metod, calling method that throws exception");
	}
}
