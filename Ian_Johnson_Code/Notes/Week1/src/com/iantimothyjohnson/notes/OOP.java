package com.iantimothyjohnson.notes;

@SuppressWarnings("unused")
public class OOP {
	// Object-oriented programming principles:

	// 1. Encapsulation: hiding/restricting access to data.
	// In Java, use private instance variables and public getters/setters.
	private static class Person {
		// We make these private so that another class can't use them directly.
		private String name;
		private String email;

		// Instead, we need getters and setters that can do validation on input,
		// etc.
		public void setName(String name) {
			this.name = name;
		}
	}
	// POJO: "plain old Java object". This is a class that just represents an
	// ordinary, day-to-day object with its characteristics.

	// 2. Abstraction: hiding implementation details (contrast with
	// encapsulation).
	// In Java, an abstract class is one that cannot be instantiated. It can
	// contain abstract methods, but it does not have to have any. You need to
	// extend an abstract class in order to make it useful.
	private static abstract class Animal {
		// Abstract methods have no implementation.
		abstract void eat();

		// Abstract classes can also have concrete methods.
		String communicate(String language) {
			return "Hi there! This animal speaks " + language + ".";
		}
	}

	// An interface is another form of abstraction. It is like a "contract"; it
	// contains a list of methods that any implementor should have.
	interface Livable {
		void reproduce();

		void eat();

		// You can provide default implementations as of Java 1.8.
		default void breathe() {
			System.out.println("I'm breathing.");
		}
	}

	// Some interfaces, such as Serializable, have no methods (a "marker
	// interface"). An interface that has only one method is a "functional
	// interface" (i.e. Runnable), and are frequently used with lambda
	// expressions.
	private static class T1 implements Runnable {
		public void run() {
			System.out.println("I'm implementing a functional interface.");
		}
	}
	// Using lambda expressions:
	// Runnable t = () -> {};

	// Interfaces can extend other interfaces; classes can extend another class
	// (only one; no multiple inheritance) or implement interfaces.
	// Multiple inheritance?
	private static interface A {
		public default void test() {
		}
	}

	private static interface B {
		public default void test() {
		}
	}

	private static interface C extends B {
	}

	private static class D implements A, C {
		// You have to override the default method for the conflict to be
		// resolved.
		@Override
		public void test() {
			// You can call one of the superclass methods here.
			C.super.test();
			// But you can't call grandparent methods:
			// B.super.test(); // Error
		}
	}

	// 3. Inheritance: making subclasses that build on other classes.
	// In Java, uses the extends or implements keywords.
	private static class C1 {
		public int x = 10;

		void test() {
		}

		int getX() {
			return x;
		}
	}

	private static class C2 extends C1 {
		public int x = 50;

		// Can't do this; you can only overload (different parameters) or
		// override (same signature).
		// String test() { return "hi"; }
		@Override
		int getX() {
			return x;
		}
	}

	// 4. Polymorphism
	// e.g. List x = new ArrayList();
	// You can only use methods that are present in the reference type.

	public static void main(String[] args) {
		Runnable t = () -> {
		};
		Runnable t2 = new Runnable() {
			public void run() {
			}
		};
		C1 c = new C2();
		System.out.println(c.x); // Prints 10.
		System.out.println(c.getX()); // Prints 50.
	}
}
