package com.iantimothyjohnson.notes;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsNotes {
	public static void main(String[] args) {
		// The most general collection interface is Collection, which is
		// extended by List, Set and Queue. Alongside Collection is Map, which
		// stores key-value pairs.

    ArrayList<Integer> nums = new ArrayList<>();
    nums.add(3);
    nums.add(1);
    nums.add(2);
    Collections.sort(nums);
    System.out.println(nums.get(0)); // Prints 1
System.out.println(Collections.max(nums)); // Prints 3
	}
}
