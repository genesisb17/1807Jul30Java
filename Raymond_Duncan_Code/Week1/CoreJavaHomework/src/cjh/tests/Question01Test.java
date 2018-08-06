package cjh.tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import cjh.question01.BubbleSort;

public class Question01Test {
	/*
	 * Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
	 */

	@Test
	public void test1() {
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		int[] sortedArray = array;
		Arrays.sort(sortedArray);
		assertArrayEquals(sortedArray,BubbleSort.sort1(array));
	}
	
	@Test
	public void test2() {
		int[] array = {85, 11, 8, 23, 43, 81, 99, 35, 48, 61, 40};
		int[] sortedArray = array;
		Arrays.sort(sortedArray);
		assertArrayEquals(sortedArray,BubbleSort.sort1(array));
	}

	@Test
	public void test3() {
		int[] array = {19, 91, 39, 25, 21, 5, 61, 60, 88, 17, 7};
		int[] sortedArray = array;
		Arrays.sort(sortedArray);
		assertArrayEquals(sortedArray,BubbleSort.sort1(array));
	}
	
	@Test
	public void test4() {
		int[] array = {47, -36, -47, -34, -25, -27, -9, -75, -96, -42, -95};
		int[] sortedArray = array;
		Arrays.sort(sortedArray);
		assertArrayEquals(sortedArray,BubbleSort.sort1(array));
	}
	
	@Test
	public void test5() {
		int[] array = {59, 88, 5, -11, 71, -26, -22, -74, -51, -47, -10};
		int[] sortedArray = array;
		Arrays.sort(sortedArray);
		assertArrayEquals(sortedArray,BubbleSort.sort1(array));
	}
}
