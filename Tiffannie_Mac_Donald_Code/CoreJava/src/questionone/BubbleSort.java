package questionone;

public class BubbleSort {

	/*
	 * Bubble sort is a sorting algorithn that works by repeatedly swapping the 
	 * adjacent elements if they are in wrong order
	 */
	public static void main(String[] args) {
		//Perform a bubble sort on the following integer array 1,0,5,6,3,2,3,7,9,8,4
		int[] mess = {1,0,5,6,3,2,3,7,9,8,4};
		
		bubbleSort(mess);						//call bubbleSort method
		
		System.out.println("Organized Array!");
		
		for(int i = 0; i < mess.length; i++) {	//loop through length of new array
			System.out.print(mess[i] + " ");	//to print elements
		}
	}
	
	
	static void bubbleSort(int mess[]) {
		int len = mess.length;
		int temp = 0;
		
		for(int i = 0; i < len; i++) { //loop through length of array
			for(int j = 1; j < (len - i); j++) {
				if(mess[j-1] > mess[j]) {		//current element is compared w/ next element
					//swap						  if the current element is greater
					temp = mess[j-1];		//that the next element, it is 'swapped'
					mess[j-1] = mess[j];		//using a temporary variable allows us to save the
					mess[j] = temp;				//a value to reassign the current index
				}
			}
		}
	}
}
