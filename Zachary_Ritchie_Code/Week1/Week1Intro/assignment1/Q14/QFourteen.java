package Q14;

import java.util.Scanner;
import java.util.Date;
import java.lang.Math;

public class QFourteen 
{

	public static void main(String[] args) 
	{
		System.out.println("Enter 1, 2, or 3 to run case");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		switch(input)
		{
			case "1":
				System.out.println("Enter a number to take square root of");
				String input2 = scan.nextLine();
				double num;
				num = Integer.parseInt(input2);
				num = Math.sqrt(num);
				System.out.println(num);
				break;
				
			case "2":
				Date date = new Date();
				System.out.println(date);
				break;
				
			case "3":
				String input3 = "I am learning Core Java";
				String[] output = input3.split("", input3.length());
				for(String v : output)
				{
					System.out.println(v);
				}
				break;
		}	
		
		scan.close();
	}
}
