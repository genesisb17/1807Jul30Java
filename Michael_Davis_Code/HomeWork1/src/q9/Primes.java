package q9;

import java.util.ArrayList;
 
public class Primes {
	public static float g=110;
	public static float p=120;
	
	
public static boolean isPrime(int n) {
	    for(int i=2;2*i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	
	static ArrayList<Integer> c=new ArrayList<Integer>();
static void printPrimes() {
	for(int i=1;i<101;i++) {
		c.add(i);
		
	}
	
	for(int a:c) {
		if(isPrime(a)==true) {
			if(a==4) {
				
			}
			else {
			System.out.println(a);
			}
		}
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printPrimes();

	}

}
