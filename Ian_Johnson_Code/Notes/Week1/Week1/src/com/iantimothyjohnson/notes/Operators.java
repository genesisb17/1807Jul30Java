package com.iantimothyjohnson.notes;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Operators {
	public static void main(String[] args) {
		int count = 0;
		// Post-increment/decrement (evaluates to original value):
		count++;
		count--;
		// Pre-increment/decrement (evaluates to new value):
		++count;
		--count;
		int x = 5, y = 6;
		if (x++ == 5 && y == x) {
			System.out.println("Sequence point");
		}

		// Left shift:
		int i = 2 << 1; // 4
		System.out.println(i);
		// (Signed) right shift:
		int j = -1 >> 1; // -1
		System.out.println(j);
		// (Unsigned) right shift:
		int k = -1 >>> 1; // 0x7FFFFFFF
		System.out.printf("0x%X\n", k);

		// instanceof:
		System.out.println(new String() instanceof Object);
		System.out.println(new ArrayList<String>() instanceof List);

		// Binary operators are short-circuiting:
		String s = null;
		// No NullPointerException here!
		if (s != null && s.contains("hi")) {
			System.out.println("what");
		}
	}
}
