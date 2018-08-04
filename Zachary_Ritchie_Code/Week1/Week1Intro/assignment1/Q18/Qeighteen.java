package Q18;

public class Qeighteen 
{
	
	public static void main(String[] args) 
	{
		String input = "1234";
		
		methodDefiner md = new methodDefiner();
		
		System.out.println("Uppercase = " + md.uppercase(input));
		System.out.println("All uppercase = "+ md.convertToInt(input));
		System.out.println("Convert to interger and add 10" + md.convertToInt(input));
	}
}
