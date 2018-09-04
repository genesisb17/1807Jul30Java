package com.ex.lifecycle;

public class Life {
	
	private String circleOfLife;
	
	public Life() {
		System.out.println("IN NO ARG CONSTRUCTOR OF LIFE");
	}

	public Life(String circleOfLife) {
		super();
		this.circleOfLife = circleOfLife;
	}

	public String getCircleOfLife() {
		return circleOfLife;
	}

	public void setCircleOfLife(String circleOfLife) {
		System.out.println("SETTING PROPERTIES");
		this.circleOfLife = circleOfLife;
	}
	
	public void live() {
		System.out.println("IM READY TO LIVE");
	}
	
	public void customInitMethod() {
		System.out.println("IN CUSTOM INIT");
	}
	
	public void customDestroyMethod() {
		System.out.println("IN CUSTOM DESTROY");
	}
	
	
	

}
