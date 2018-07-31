package com.iantimothyjohnson.assignments;

public class OOPPrinciples {
	// The four principles are:
	// 1. Abstraction (abstract methods, classes; interfaces)
	// 2. Encapsulation (private instance vars; public getters/setters)
	// 3. Polymorphism (overloading; overriding; A a = new B();)
	// 4. Inheritance (extends; implements)
	public static void main(String[] args) {
		Programmer ian = new Programmer("Ian", 22, "Java");
		Ant niceAnt = new Ant(true);
		// Polymorphism: the Ant is stored in a variable of type Animal.
		// Inheritance: the class Ant extends Animal, which makes the above
		// possible.
		Animal nastyAnt = new Ant(false);

		// Abstraction: the Worker interface abstracts the properties of being a
		// hard worker, as both programmers and ants are.
		ian.doWork();
		niceAnt.doWork();
		// This doesn't work, since nastyAnt has type Animal at compile time:
		// nastyAnt.doWork();
		// But this does (type conversion at runtime):
		((Ant)nastyAnt).doWork();

		// Polymorphism: interact expects an argument of type Person; type
		// Programmer will do, since it's a subclass.
		niceAnt.interact(ian);
		nastyAnt.interact(ian);

		// Encapsulation: implementation details are hidden and exposed through
		// getters and setters.
		System.out.println("Ian's name is " + ian.getName() + " and he is " + ian.getAge() + " years old.");
		nastyAnt.setFriendly(true); // The ant was reformed.
		nastyAnt.interact(ian);
	}
}
