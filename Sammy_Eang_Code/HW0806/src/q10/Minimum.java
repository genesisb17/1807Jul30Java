package q10;

public class Minimum {

	public static void main(String[] args) {
		// calls function to test
		min(2, 1);
	}
	
	//function which takes two variables
	static void min(int a, int b) {
		//is first variable less than the last? if so, first variable is stored. If not, last is.
		int c = (a < b) ? a : b;
		//print out stored variable
		System.out.println(c);
	}

}
