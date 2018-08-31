
public class Methods {
	
	
		public static int[] bubSor(int [] nums) {
		for (int i=0; i<nums.length-1; i++) {	
			int temp;
			if(nums[i]>nums[i+1]) {
				temp=nums[i];			
				nums[i]=nums[i+1];
				nums[i+1]=temp;		
			}	
		}
		
		return nums;
		
	}
}


