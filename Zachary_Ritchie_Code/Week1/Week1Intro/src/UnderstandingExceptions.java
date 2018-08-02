import java.io.IOException;

public class UnderstandingExceptions {

	public static void main(String[] args)
	{
		try {
			exploreStack(args);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Catching exception e in main");
		}
		
		System.out.println("Reached the end of the first risky block");
		
		try
		{
			propagate();
		}
		catch(MyException e)
		{
			System.out.println("Exception Message: "+ e.getMessage());
		}
		
	}
	
	static void dothings(String[]args) 
	{
		try
		{ //MUST use either catch, finally, or both
			System.out.println(args[5].toLowerCase());
			throw new IOException();
		}
		catch(IOException e)
		{
			System.out.println("Caught IOE");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			System.out.println("Caught AIOOBE");
		}
	
	}
	
	static void exploreStack(String[]args) throws Exception
	{
		
		dothings(args);
		System.out.println("Exception in throw stack");
		throw new Exception();
	}
	
	static void throwingCustom(String issue) throws MyException
	{
		String message = "this is out problem" + issue;
		throw new MyException(message);		
	}
	
	static void propagate() throws MyException
	{
		throwingCustom("In propagate method, calling metho that throws...");
	}

}
