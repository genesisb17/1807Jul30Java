package com.ex.lifecycle;

import org.springframework.context.Lifecycle;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		// Should only be used to expose lifecycle. Not in practice app
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
		Life life = (Life) context.getBean("life");
		life.live();
		context.close();	
	}
}
