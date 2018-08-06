package com.revature.designpatterns;

public class ToolFactory {
	public static Tools instantiate(String toolType) {
		switch(toolType.toLowerCase()) {
		case "hammer" : return new Hammer();
			//break; here would be unreachable code
		case "wrench" : return new Wrench();
		case "screwdriver" : return new Screwdriver();
		default: return null;
		}
	}
}
