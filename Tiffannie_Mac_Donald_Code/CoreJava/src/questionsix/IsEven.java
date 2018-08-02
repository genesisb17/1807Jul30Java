package questionsix;

public class IsEven {
	/*
	 * Write  a program  to  determine  if  an  integer
	 * is  even  without  using  the  modulus operator (%)
	 */
	public static void main(String[] args) {
		
		//specify which integer you want to check
		int n = 4571;
		
		//integer division uses flooring which means if the quotient ends in .4 it rounds down
		if((n / 2)*2 == n ) { //if the number / 2 * 2 is itself. then its even.
			System.out.println(n + ": is even!");
		} else {
			System.out.println(n + ": is odd!");
		}

	}

}
