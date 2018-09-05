package com.ex.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app {

	public static void main(String[] args) {
		
		// Wrong
		helloWorld hello =new helloWorld();
		System.out.println(hello.getMessage());
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		helloWorld world = (helloWorld) context.getBean("thisIsABean");
		System.out.println(world.getMessage());
		
		world.setMessage("Hello I changed");
		System.out.println(world.getMessage());
		

		DependentBean d = (DependentBean) context.getBean("dependent");
		System.out.println(d.getHello().getMessage());
	}
}
