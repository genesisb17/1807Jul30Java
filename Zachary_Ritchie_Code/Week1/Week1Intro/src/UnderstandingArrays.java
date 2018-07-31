import java.util.Arrays;

public class UnderstandingArrays 
{
	public static void main(String[] args) 
	{
		/**An arrya is a group of variables
		 * elements of an array must be the smae type 
		 * elements are accessed by and index
		 * the first element is the oth index
		 * find an arras size with the arrayName.length 
		 */
		
		int[] nums = {9, 5, 2, 10};
		int [] n = new int[5];
		//n[10] = 7;
		
		/* In order to intialize and array
		 * we must either explicitly add its values
		 * or specify the size we want to allocate to it
		 */
		
		int length = nums.length;
		
		int[][] twoD = new int [4][4];
		twoD[0][0] = 'X';
		twoD[0][1] = 1;
		twoD[1][0] = 1;
		
		for(int i=0; i < twoD.length; i++)
		{
			for(int j=0; j < twoD[i].length; j++)
			{
				System.out.println(twoD[i][j]);
			}
			System.out.println();
		}
		
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	//var args
	//can only have one per param list, and must be lst in the param list
	// var args and param both refered to methods
}
