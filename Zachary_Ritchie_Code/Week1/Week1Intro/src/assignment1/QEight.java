package assignment1;

import java.util.ArrayList;
import java.util.Arrays;

public class QEight {

	public static void main(String[] args) 
	{
		ArrayList<String> input = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
		
		ArrayList<String> palindromes = new ArrayList<String>();
		
		
		for (String word : input) 
		{
			StringBuilder convertString1 = new StringBuilder();
			convertString1.append(word);
			StringBuilder convertString2 = new StringBuilder();
			convertString2.append(word);
			convertString2.reverse();
			
			if (convertString1.toString().equals(convertString2.toString()))
			{
				palindromes.add(word);
			}
		}
		
		for(String pali : palindromes)
		{
			System.out.println(pali);
		}
		
	}

}
