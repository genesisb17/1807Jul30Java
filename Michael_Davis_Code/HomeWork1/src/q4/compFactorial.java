package q4;

public class compFactorial {
	static int compute(int n) {
		
		  int x=1;
		  int factorial = 1;
		  for ( x = n; x > 1; x--)
		     factorial *= x;

		  return factorial;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(compute(4));

	}

}
