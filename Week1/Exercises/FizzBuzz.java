public class FizzBuzz{
	public static void main(String[] args) {
	 //Asks the user for input
	 /*Scanner scan = new Scanner(System.in);
	 int n = scan.nextInt();*/
	 
	 //Access first element of String Array
	 String num = args[0];
	 //Parse String into int
	 int n = Integer.parseInt(num);
	 
	 //boxing turns an integer class into an int and vice versa
	 
		for(int i = 0; i < n; i++) {
			if(i % 15 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else if (i%3==0) {
				System.out.println("Fizz");
			} else {
				System.out.println(i);
			}
		}
	}
}