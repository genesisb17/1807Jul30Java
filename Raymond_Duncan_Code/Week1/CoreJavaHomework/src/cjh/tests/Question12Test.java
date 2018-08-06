package cjh.tests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import cjh.question12.Evens;

public class Question12Test {
	/*
	 * Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
	 * Use the enhanced FOR loop for printing out the numbers.
	 */

	@Test
	public void test() {
		int[] nums = new int[100];
		int[] evens = new int[50];
		for(int i = 1; i < 101; i++) {
			nums[i-1] = i;
		}
		for(int i = 1; i < 51; i++) {
			evens[i-1] = 2*i;
		}
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Evens.getEvens(nums);
		String expected = "2\n4\n6\n8\n10\n12\n14\n16\n18\n20\n22\n24\n26\n28\n30\n32\n34\n36\n38\n40\n42\n44\n46\n48\n50\n"
				+ "52\n54\n56\n58\n60\n62\n64\n66\n68\n70\n72\n74\n76\n78\n80\n82\n84\n86\n88\n90\n92\n94\n96\n98\n100\n";
		assertEquals(expected,outContent.toString());		
	}

}
