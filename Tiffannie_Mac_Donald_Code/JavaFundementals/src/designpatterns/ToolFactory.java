package designpatterns;

public class ToolFactory {
	
	public static Tool instantiate(String toolType) {
		switch(toolType) {
		case "hammer": return new Hammer();
		case "wrench": return new Wrench();
		default: return null; //need this for an else statement and to return something
		}
	}
}
