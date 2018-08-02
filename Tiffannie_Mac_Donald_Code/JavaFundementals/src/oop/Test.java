package oop;

public class Test {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.breathe();
		((Animal)d).consume();
		d.stayinAlive();
		
	}

}
