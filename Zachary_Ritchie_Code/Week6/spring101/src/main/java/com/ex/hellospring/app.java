package com.ex.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app 
{
	public static void main(String[] args)
	{
		
		//Wrong! Not Using Spring
		/*
		 * HelloWorld hello = new HelloWorld();
		 * System.out.println(hello.getMessage());
		*/
		
		/*ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld world = (HelloWorld) context.getBean("thisIsABean");
		System.out.println(world.getMessage());
		
		
		dependentBean d = (dependentBean) context.getBean("dependent");
		System.out.println(d.getHello().getMessage());*/
	}
}
