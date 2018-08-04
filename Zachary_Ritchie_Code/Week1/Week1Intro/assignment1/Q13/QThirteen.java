package Q13;

public class QThirteen {

	public static void main(String[] args) 
	{
		int counter = 0;
		for(int i = 1; i <= 4; ++i)
		{
			for(int j = 1; j <= i; ++j)
			{
				if (counter%2 == 0)
				{
					System.out.print("0");
				}
				else
				{
					System.out.print("1");
				}	
				++counter;
			}			
			System.out.println();
		}	
	}
}
