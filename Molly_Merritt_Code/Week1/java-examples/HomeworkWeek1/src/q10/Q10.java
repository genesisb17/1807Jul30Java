package q10;

/*
 * Find the minimum of two numbers using ternary operators.
 */

public class Q10 {
	
	public static void main(String[] args) {
		int n1 = (int) Math.floor(Math.random()*100);
		int n2 = (int) Math.floor(Math.random()*100);
		int n = (n1 < n2) ? n1 : n2;
		System.out.println("The minimum of " + n1+ " and " + n2 + " is " + n);
	}

}
