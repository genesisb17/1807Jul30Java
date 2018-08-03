package assignment1;

public class QTwelve {

	public static void main(String[] args) 
	{
		int[] nums = new int[100];
		
		for(int i = 0; i <= 100 - 1; ++i)
		{
			nums[i] = i + 1;
		}
		
		for(int even : nums)
		{
			if (even % 2 == 0)
			{
				System.out.println(even);
			}
		}
	}

}
