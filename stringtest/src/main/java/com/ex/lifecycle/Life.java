package com.ex.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Life implements InitializingBean, DisposableBean, BeanFactoryAware, 
	BeanPostProcessor, BeanNameAware, ApplicationContextAware {
	/*
	 * Spring Bean Lifecycle
	 */

	private String circlOfLife;
	
	public Life() {
		System.out.println("In no arg constructor for life");
		
	}

	public Life(String circlOfLife) {
		super();
		this.circlOfLife = circlOfLife;
	}

	public String getCirclOfLife() {
		return circlOfLife;
	}

	public void setCirclOfLife(String circlOfLife) {
		this.circlOfLife = circlOfLife;
	}
	
	public void live() {
		System.out.println("Lets Live");
	}
	
	public void customInit() {
		System.out.println("im init");
	}
	
	public void customDestroyMethod() {
		System.out.println("Im destroying");
	}



	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("this is my Application context call");
		
		
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("This is my Process BEFORE Initialization");
		
		
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("This is my process AFTER Initialization");
		
		
		return null;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("This is my method call to setBeanFactory");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("This is my method call to destroy my Bean");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("This is my method call to after Properties set.");
		
	}

}
