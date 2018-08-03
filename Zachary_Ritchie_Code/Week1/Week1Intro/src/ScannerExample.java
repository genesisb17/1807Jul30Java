// ctrl shift o
import java.util.Scanner;
//import static java.lang.System.in;
//^ staitc imports allow us to access stati fields of a class w/o class...

public class ScannerExample 
{

	public static void main(String[] args) 
	{
		System.out.println("Enter Name");		
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		System.out.println("Welcome, " + name + ". Please enter age");
		String age = scan.nextLine();
		int a;
		try 
		{
			 a = Integer.parseInt(age);
		}
		catch(NumberFormatException nfe)
		{
			nfe.printStackTrace();
			System.out.println("You did not enter a vali number");
			a = 5;
		}
		System.out.println(a);
		
		scan.close();
	}

}
