package Q19;

import java.util.ArrayList;

public class Nineteen {

	public static void main(String[] args) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10; ++i)
		{
			list.add(i);
		}
		
		for(int num : list)
		{
			System.out.print(num + " ");
		}
		System.out.println();
		
		int evenNumber = 0;
		for(int evenNum : list)
		{
			if(((evenNum/2)*2) == evenNum)
			{
				evenNumber = evenNumber + evenNum;
			}
		}
		System.out.println(evenNumber);
		
		int oddNumber = 0;
		for (int oddNum : list)
		{
			if(((oddNum/2)*2) != oddNum)
			{
				oddNumber = oddNumber + oddNum;
			}
		}
		System.out.println(oddNumber);
		
		
		for (Integer i = 1; i <= 10; ++i)
		{			
			if(!primeCheck(i))
			{
				list.remove(i);
			}
		}
		
		for(int num2 : list)
		{
			System.out.print(num2 + " ");
		}
		System.out.println();
	}
	
	static boolean primeCheck(int p) 
	{
		if(p == 1)
		{
			return true;
		}
		for(int i = 2; i < p; i++) 
		{
	        if(p % i == 0)
	        {
	        	return true;
	        }	            
	    }		
		return false;
	}
}
