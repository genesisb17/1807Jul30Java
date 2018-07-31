import java.util.*;
public class FizzBuzz {
	
	//Scanners
	//wrapper classes
	//Strings
	//ararys
	
	public static void FizzBuzz(int n) {
		String output="";
		int i=0;
		int a=n;
		if(n!=0) {
			
		
		if((n%3==0)){
			
			System.out.print("Fizz ");
			i++;
			FizzBuzz(n-1);
		}
		else if(n%5==0){
			System.out.print("Buzz  ");
			i++;
			FizzBuzz(n-1);
			
		}
		else if(n%15==0){
			System.out.print("FizzBuzz ");
			i++;
			FizzBuzz(n-1);
		}
		else {
			System.out.print(n+" ");
			i++;
			FizzBuzz(n-1);
			
		}
		}
		}
		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			FizzBuzz(20);
		/*Scanner x=new Scanner(System.in);
		 * 
		 * 
		 * 
		 */
	}

}
