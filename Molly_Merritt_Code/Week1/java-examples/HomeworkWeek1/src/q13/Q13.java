package q13;

/*
 * Display the triangle on the console as follows by using any type of loop. Do
 * NOT use a simple group of print statements to accomplish this.
 */

public class Q13 {
	
	public static void main(String[] args) {
		
		for (int i=0; i<10; i++) {
			if (i%2 == 0) {
				System.out.print(0);
			} else {
				System.out.print(1);
			} if ((i+1 == 1) || (i+1 == 1+2) || (i+1 == 1+2+3) || (i+1 == 1+2+3+4))  {
				System.out.println("");
			}
		}
		
	}

}
