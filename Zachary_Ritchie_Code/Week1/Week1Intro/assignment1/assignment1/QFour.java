package assignment1;

public class QFour {

	public static void main(String[] args) 
	{
		int input = 9;
		
		int output = 1;
		
		for (int i = 0; i <= input - 1; ++i)
		{
			output = output * (input - i);
		}
		
		System.out.println(output);
	}

}
