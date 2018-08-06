package cjh.question13;

public class Triangles {
	/*
	 * Display the triangle on the console as follows using any type of loop. Do NOT use a simple group of print statements to accomplish this. 
	 * 0
	 * 1 0
	 * 1 0 1
	 * 0 1 0 1
	 * 
	 */
	public static void main(String[] args) {
		printTriangle(3);
	}
	
	public static void printTriangle(int n) {
		boolean toggle = false;
		for(int i = 0, j; i < n; i++) {
			j = i+1;
			while(j > 0) {
				if(toggle) System.out.print("1");
				else System.out.print("0");
				if(j-- > 1) System.out.print(" ");
				else System.out.print("\n");
				toggle = !toggle;
			}
			
		}
	}

}
