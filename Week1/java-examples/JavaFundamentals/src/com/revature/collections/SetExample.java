package com.revature.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	

	public static void main(String[] args) {
	
	}
	
	public static void hashSetExample() {
		Set<Character> alphabet = new HashSet<>();
		// Insert elements to our Set with the add(E e) method
		alphabet.add('a');
		alphabet.add('a');
		alphabet.add('a');
		alphabet.add('b');
		alphabet.add('e');
		alphabet.add('c');
		alphabet.add('d');
		alphabet.add('e');
		alphabet.add('f');
		alphabet.add('g');
		alphabet.add('H');
		alphabet.add('i');
		alphabet.add('j');
		alphabet.add('h');
		
		// How do we iterate through a Set??
		// Option 1: enhanced for-loop
		for (Character c : alphabet) {
			System.out.println(c);
		}
		
		System.out.println("========");
		System.out.println("Using an Iterator");
		// Option 2: Use an Iterator
		Iterator<Character> it = alphabet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void treeSetExample() {
		Set<Double> myTreeSet = new TreeSet<>();
		myTreeSet.add(new Double(99.8));
		myTreeSet.add(-35.0);
		myTreeSet.add(3.14);
		myTreeSet.add(6.17);
		myTreeSet.add(0.0);
		myTreeSet.add(9138724598.09);
		myTreeSet.add(35.0);
		myTreeSet.add(6.17);
		
		// Iterating through a TreeSet
		// Option 1: Enhanced For Loop
		for (Double d : myTreeSet) {
			System.out.println(d);
		}
		
		System.out.println("======");
		System.out.println("Using an Iterator");
		// Option 2: Iterator
		Iterator<Double> it = myTreeSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}


}
