package Q2;

public class QTwo {

	public static void main(String[] args)
	{
		int x = 1;
		int y = 1;
		int z = 0;
		
		//loop through the first 25 of the sequence
		for (int i = 1; i <= 25; ++i)
		{
			//compute the first numbers
			z = x + y;
			//print the first numebr
			System.out.println(z);				
			//shift numbers
			y = x;
			x = z;
		}
	}

}
