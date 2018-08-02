
public class Dog extends Animal
{

	@Override
	public void breathe() {
		System.out.println("Dogs Breathe");
	}

	@Override
	public void consume() {
		System.out.println("Dogs go everywhere");
		
	}

	@Override
	public void excrete() 
	{
		System.out.println("Dogs eat eveything");
	}
	
}
