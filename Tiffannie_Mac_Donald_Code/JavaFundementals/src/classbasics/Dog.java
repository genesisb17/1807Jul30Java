package classbasics;

public abstract class Dog {
	
	protected String breed;
	protected String size;
	protected Boolean fed;
	
	
	public Dog() {};
	//constructor
	public Dog(String breed, String size, Boolean fed) {
		super();
		this.breed = breed;
		this.size = size;
		this.fed = fed;
	}
	
	//overloading
	public Dog(String breed) {
		this.size = "Large";
		this.fed = true;
	}
	
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Boolean getFed() {
		return fed;
	}

	public void setFed(Boolean fed) {
		this.fed = fed;
	}
	
	


}
