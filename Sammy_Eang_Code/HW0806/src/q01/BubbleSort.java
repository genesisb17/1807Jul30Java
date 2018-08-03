package q01;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		//Declares array of values
		int[] ex = {1,0,5,6,3,2,3,7,9,8,4};
		//A temporary variable to take the place of a replaced array element
		int replace = 0;
		
		//Goes up the array
		for(int count = 0; count < ex.length - 1; count++) {
			//If array value is bigger than next array value
			if(ex[count] > ex[count+1]) {
				//Assign bigger number to a temporary variable
				replace = ex[count];
				//Make the index in the array into the smaller number above it
				ex[count] = ex[count+1];
				//Make the index above the now smaller number into the bigger number
				ex[count+1] = replace;
				//Reset counter to go back through entire array if a swap happened
				count = 0;
			}
		}
		
		System.out.println("Here is the sorted array: ");
		//Goes up array
		for(int count = 0; count < ex.length; count++) {
			//Prints the number in the array
			System.out.print(ex[count]+", ");
		}
		
		//Done!
	}
}
