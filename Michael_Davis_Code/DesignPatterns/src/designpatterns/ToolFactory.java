package designpatterns;

public class ToolFactory {
	
	public static Tool instantiate(String toolType) {
		switch(toolType) {
		
		
		case "hammer": return new Hammer();
		case "wrench": return new Wrench();
		case "screwdriver": return new ScrewDriver();
		
		default: return null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
