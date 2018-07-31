package OOP;

public class Employee extends User
{
	String favColor;
	Boolean registered;
	
	public Employee(String name, int height, String favColor)
	{
		super("null", 0);
		this.favColor = "null";
	}
	
	public Employee(String name, int height, String favColor, Boolean registered)
	{
		super(name, height);
	}		
	
	public String getFavColor() {
		return favColor;
	}
	public void setFavColor(String favColor) {
		this.favColor = favColor;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Boolean getRegistered() {
		return registered;
	}
	public void setRegistered(Boolean registered) {
		this.registered = registered;
	} 

}
