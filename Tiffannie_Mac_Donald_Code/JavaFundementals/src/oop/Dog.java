package oop;

//it's a concrete class
public class Dog extends Animal {

	@Override //forces method to override method from parent class of same name
	public void breathe() { 
		// TODO Auto-generated method stub
		System.out.println("dogs breath. woof");
	}

	//@Override //you also do not have to override since it's implicit. it will just
			//force this method to override
//	public void consume() {//because this is implemented in Animal, we do not have
//		// to implement it here, in Dog
//		
//	}

	@Override
	public void excrete() {
		// TODO Auto-generated method stub
		System.out.println("poop");
	}

	//don't have to implement stayinAlive() because it's already implemented 
	//in Livable
}
