package com.revature.datatypes;

public class Wrappers {
	public static void main(String[] args) {
		/*
		 * byte	8 bits
		   short	16 bits
		   int	32 bits
		   long	64 bits
		   float	32 bits
		   double	64 bits
		   boolean	N/A
	       char	16 bits
		 */
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		int five = Integer.parseInt("5");
		int willCauseException = Integer.parseInt("one hundred");
		
		Integer i = new Integer(80);
		int eighty = i; //unboxing
		
		int x = 10;
		Integer wrapped = x;
	}
}
