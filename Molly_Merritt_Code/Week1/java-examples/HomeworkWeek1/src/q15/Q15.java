package q15;

/*
 * Write a program that defines an interface having the following methods:
 * addition, subtraction, multiplication, and division. Create a class that
 * implements this interface and provides appropriate functionality to
 * carry out operations. Hard code two operands in a test case having a main
 * method that calls the implementing class.
 */

public class Q15 implements Q15able {
	
	public static void main(String[] args) {
		Q15 q15 = new Q15();
		double d1 = 5;
		double d2 = 10;
		double dAdd = q15.addition(d1,d2);
		double dMultiply = q15.multiplication(d1, d2);
		if (dAdd == d1+d2) {
			System.out.println("Addition passes test");
		} else { System.out.println("Addition fails test"); }
		if (dMultiply == d1*d2) {
			System.out.println("Multiplication passes test");
		} else { System.out.println("Multiplication fails test"); }
	}

	public double addition(double d1, double d2) {
		return d1+d2;
	}

	public double subtraction(double d1, double d2) {
		return d1-d2;
	}

	public double multiplication(double d1, double d2) {
		return d1*d2;
	}

	public double division(double d1, double d2) {
		return d1/d2;
	}

}
