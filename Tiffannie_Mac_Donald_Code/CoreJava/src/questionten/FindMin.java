package questionten;

public class FindMin {
	
	//Find the minimum of two numbers using ternary operators
	public static void main(String[] args) {
		
		//begin with two numbers
		int a = 8;
		int b = 7;
		
			//if a < b then a otherwise b
		int min = a < b ? a : b;
		System.out.println(min);
	}
}
