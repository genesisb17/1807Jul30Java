package com.iantimothyjohnson.notes.week6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// Wrong! This does not use Spring properly:
		// HelloWorld hello = new HelloWorld();
		// System.out.println(hello.getMessage());

		// We instead need to set up our ApplicationContext:
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// There are two ways to get our bean:
		// By ID
		HelloWorld hello = (HelloWorld) context.getBean("firstBean");
		// By class
		HelloWorld world = context.getBean(HelloWorld.class);
		System.out.println(hello.getMessage());
		System.out.println(world.getMessage());
		world.setMessage("Hello!");
		System.out.println(hello.getMessage());
		System.out.println(world.getMessage());
		HelloWorld world2 = context.getBean(HelloWorld.class);
		System.out.println(world2.getMessage());
		
		// Let's test our our DependentBean:
		DependentBean dependent = context.getBean("dependent", DependentBean.class);
		System.out.println(dependent.getHello().getMessage());
	}
}
