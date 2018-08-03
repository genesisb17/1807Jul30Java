package q04;

public class Factorial {

	public static void main(String[] args) {
		
		//Using our factorial function
		factorial(3);
		
	}

	//Factorial function
	static void factorial(int num) {
		//Declaring sum, what factorial will be stored in
		int sum = num;
		//Loop going from highest to lowest
		for (int i = num; i > 1 ; i--) {
			//Sum is current number minus previous number
			sum *= (i-1);
		}
		
		//Printing out the factorial
		System.out.println(sum);
	}
}
