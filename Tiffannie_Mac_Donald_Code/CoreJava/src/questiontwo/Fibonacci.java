package questiontwo;

public class Fibonacci {

	/*
	 * Classic fibonacci sequence
	 * f(0) = 0
	 * f(1) = 1
	 * f(n) = f(n-1) + f(n-2) for n >= 2
	 */
	public static void main(String[] args) {
		//write a program to display first 25 fibonacci numbers beginning @ 0
		
		int num = 25;
		
		int[] numbers = new int[num];
		
		//an iterative solution to coding the fibonacci sequence
		
		//begin with the base case since it will always be the same
		numbers[0] = 0;
		numbers[1] = 1;
		
		//then work up to n by filling the indices with values from the sequence
		//adding the previous indice's value to the next one
		for(int i = 2; i < num; i++) {
			numbers[i] = (numbers[i-1] + numbers[i-2]);
		}
		
		//printing out the values in our series
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		//System.out.println(classicFibonacci(num));
		
	}
	
// *	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*
	//only printing final int. not sure I want to think about how to work the 
	//recursive version
//	static int classicFibonacci(int n) {
//		
//		if (n <= 1) {
//			 //System.out.print(n);
//			 return n;
//		}
//		else {
//			//System.out.println(classicFibonacci(n-1) + classicFibonacci(n-2));
//			
//			return classicFibonacci(n-1) + classicFibonacci(n-2);
//		}
//		
//	}
	
	//TODO if time, do a memoized version
	static void memoFib(int n) {
		
	}

}
