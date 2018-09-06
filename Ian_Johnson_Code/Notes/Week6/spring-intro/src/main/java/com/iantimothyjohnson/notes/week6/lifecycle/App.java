package com.iantimothyjohnson.notes.week6.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Life life = context.getBean("life", Life.class);
		life.live();

		context.close();
	}
}
