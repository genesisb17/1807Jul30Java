package q16;

import java.util.Scanner;

public class CalcLength {
	
	
	
	
	static int wordLength() {
		
		
		
		System.out.println("Please enter a word you would like to know the length of");
		
		
		Scanner a=new Scanner(System.in);
		
		String word=a.nextLine();
		
		return word.length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.out.println(wordLength());
	}

}
