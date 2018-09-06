package com.iantimothyjohnson.notes.week6.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iantimothyjohnson.notes.week6.beans.Author;
import com.iantimothyjohnson.notes.week6.service.AuthorService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		AuthorService authorService = context.getBean(AuthorService.class);

		Author a = new Author("Ian", "Johnson", null);
		authorService.addAuthor(a);

		System.out.println(authorService.getAll());
	}
}
