package q19;
import java.util.ArrayList;

import q9.Primes;

public class ArrayWork {
	
	public static void actualwork() {
		ArrayList<Integer> a=new ArrayList<Integer>();
		ArrayList<Integer> b=new ArrayList<Integer>();
		
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(8);
		a.add(9);
		a.add(10);
		
		
		int eventotal=0;
		int oddtotal=0;
	//	Primes a=new Primes();
		
		for(int z:a) {
			if(z%2==0) {
				eventotal+=z;
			}
			else oddtotal+=z;
			
		}
		/*
		for(int g:a) {
			if(Primes.isPrime(g)) {
				a.remove(g);
				
			}
		}
		*/
		System.out.println("The even total is: "+eventotal);
		System.out.println("The odd total is "+oddtotal);
		for(int d:a) {
			
			int o=0;
			Primes p=new Primes();
			if(Primes.isPrime(d)) {
				b.add(d);
			}
			
		}
		System.out.println("Prime Array:"+b.toString());
	}
	
	public static void main(String[] args) {
		
		
		//ArrayWork b=new ArrayWork();
		ArrayWork.actualwork();
		
		
		
	}
}
