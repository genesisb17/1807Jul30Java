package com.test.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("beans.xml");
		Lifecycle life = (Lifecycle) context.getBean("thisIsABean");
		life.doThings();
		context.close();
		
	}

}
