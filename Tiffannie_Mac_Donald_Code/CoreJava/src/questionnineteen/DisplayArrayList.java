package questionnineteen;

import questionsix.IsEven;
import questionnine.PrintPrimes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class DisplayArrayList {
/*
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all
 * the even numbers up and display the result. Add all the odd numbers up and display the
 * result.  Remove  the  prime  numbers  from  the  ArrayList  and  print  out  the  
 * remaining ArrayList
 */
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10)) ;
		
		System.out.print("Array--> ");
		for(int num : ints) {
			System.out.print(num + " ");
		}
		System.out.println("\n");
		int even = 0;
		int odd = 0;
		int prime = 0;
		for(int num : ints) {
			if(IsEven.isEven(num)) {
				//System.out.println(even + " even");
				even = even + num;
			} else {
				//System.out.println(odd);
				odd = odd + num;
			}			
		}
		for(int i = 0; i< ints.size(); i++) {
			if(PrintPrimes.isPrime(ints.get(i))) {
				//System.out.println(ints.get(i));
				ints.remove(ints.get(i));
			}
		}
		
		System.out.println("Sum of evens is " + even);
		System.out.println("Sum of odds is " + odd + "\n");
		
		System.out.print("Array without primes--> ");
		for(int num : ints) {
			System.out.print(num + " ");
		}
	}

}
