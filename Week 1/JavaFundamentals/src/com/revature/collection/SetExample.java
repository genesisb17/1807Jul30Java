package com.revature.collection;

import java.util.Set;
import java.util.*;

public class SetExample {
	
	public static void main(String[] args) {
		Set<String> hash_Set = new HashSet<String>();
		hash_Set.add("This");
		hash_Set.add("is");
		hash_Set.add("an");
		hash_Set.add("example");
		hash_Set.add("example");
		
		System.out.println(hash_Set);
		
		Set<String> tree_Set = new TreeSet<String>();
		tree_Set.add("Whaaaaaaaaat");
		tree_Set.add("good");
		tree_Set.add("you");
		System.out.println(tree_Set);
	}
}
