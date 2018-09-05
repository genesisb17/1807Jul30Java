package com.ex.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("beans.xml");
		
		Life me = (Life) context.getBean("life");

		me.live();
		
//		context.close();
		
	}
	
	
}
