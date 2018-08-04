package Q1;

public class QOne {

	public static void main(String[] args) 
	{
		int[] nums = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int placeHolder = 0;
		boolean done = false;
		boolean swap = false;
		
		do
		{
			//Loop through each variable and compare them
			for (int i = 0; i <= nums.length - 2; i++)
			{
				//swap them if needed
				if (nums[i] > nums[i + 1])
				{
					placeHolder = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = placeHolder;
					swap = true;					
				}					
			}
			
			//check to see if we swapped any numebrs
			if(swap == false)
			{
				done = true;
			}
			
			//reset swap for next itteration
			swap = false;
		}while(done == false);
		
		//print numbers in array
		for (int numbers : nums)
		{
			System.out.println(numbers);
		}
		
	}

}
