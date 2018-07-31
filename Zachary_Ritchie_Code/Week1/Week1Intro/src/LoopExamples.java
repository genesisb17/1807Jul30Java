
public class LoopExamples {

	public static void main(String[] args) 
	{
		int limit = 11;
		Boolean done = false;
		
		do
		{
			for (int i = 0; i <= limit; i++)
			{
				limit--;
				
				if (limit == i)
				{
					System.out.println("i (" + i + ") and limit (" + limit + ") are equal");
					break;
				}	
				if (limit == 4)
				{
					done = true;
				}
			}
			
		}while (done);
		
		System.out.println("Completed");
	}
	
}
