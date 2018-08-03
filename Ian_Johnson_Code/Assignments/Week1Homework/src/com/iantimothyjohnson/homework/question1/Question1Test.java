package com.iantimothyjohnson.homework.question1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Question1Test {
	@Test
	public void testBubbleSort() {
		int[] toSort = {1,0,5,6,3,2,3,7,9,8,4};
		int[] expected = Arrays.copyOf(toSort, toSort.length);
		Arrays.sort(expected);
		Question1.bubbleSort(toSort);
		assertArrayEquals(expected, toSort);
	}
}
