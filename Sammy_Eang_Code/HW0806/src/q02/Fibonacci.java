package q02;

public class Fibonacci {

	public static void main(String[] args) {
		
		//Declaring int array of size 25
		int[] fibb = new int[25];
		
		//Gives initial values
		fibb[0] = 0;
		fibb[1] = 1;
		
		//Starting at 2nd element of array (where calculation begins)
		for(int count = 2; count < fibb.length; count ++ ) {
			//The current index is equal to the sum of the last two indexes
			fibb[count] = fibb[count - 1] + fibb[count - 2];
		}
		
		System.out.println("Here is the first 25 elements of the fibbonacci sequence: ");
		for(int count = 0; count < fibb.length; count++) {
			//Prints the number in the array
			System.out.print(fibb[count]+", ");
		}
		
		//Done!

	}

}
