package com.revature.designpatterns;

public interface Tool {
	
	public default String work() {
		return "Just a plain old tool";
	}

}
