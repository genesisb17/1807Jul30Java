package assignment1;

import java.util.ArrayList;

public class QNine {

	public static void main(String[] args)
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> primeNums = new ArrayList<Integer>();
		
		for(int i = 1; i <= 100; ++i)
		{
			nums.add(i);
		}
		
		for (Integer input : nums)
		{
			if(primeCheck(input))
			{
				primeNums.add(input);
			}
		}
		
		for(Integer output : primeNums)
		{
			System.out.println(output);
		}		
	}
	
	static boolean primeCheck(int p) 
	{
		for(int i = 2; i < p; i++) 
		{
	        if(p % i == 0)
	        {
	        	return false;
	        }	            
	    }
		return true;
	}
}
