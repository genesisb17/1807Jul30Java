package questionsixteen;

public class NumberCharacters {
/*
 * Write a program to display the number of characters for a stringinput. The 
 * string should be entered as a command line argument using(String [] args)
 */
	public static void main(String[] args) {
		System.out.println("Number of characters in your string");
		
		//split to have separate characters
		String[] toBeCounted = args[0].split("");
		
		//count how many elements
		int numChars = toBeCounted.length;
		
		System.out.println(numChars);
	}

}
