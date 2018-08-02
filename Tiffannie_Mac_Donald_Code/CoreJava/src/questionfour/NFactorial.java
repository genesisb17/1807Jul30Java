package questionfour;

public class NFactorial {

	public static void main(String[] args) {
		// write a program to compute N factorial
		//if given a number is will compute n-1 x n-2 x n-3 ... all the way till 1
		
		//specify N
		int n = 5;
				
		//where we will store our 'previous' value
		int NFactorial= 1;
		
		for(int i = 1; i < n + 1; i++) {  	//loop from 1 to the number
			//System.out.println(i);
			NFactorial *= i; //nf = nf * 1	//multiply the previous value to the current value
			
		}
		
		System.out.println("N Factorial = " + NFactorial);
	}

}
