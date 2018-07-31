package classbasics;

public class Chihuahua extends Dog {

	public int shakeLevel;
	
	public Chihuahua() {};
	
	public Chihuahua(String breed, String size, Boolean fed, int howShakey) {
		super(breed, size, fed);
		shakeLevel = howShakey; 
		breed = "Chihuahua";
		size = "small";
		fed = true;
	}
	
	public void setShakeLevel(int newValue) {
		shakeLevel = newValue;
	}
	
	public int getShakeLevel() {
		return shakeLevel;
	}
	


}
