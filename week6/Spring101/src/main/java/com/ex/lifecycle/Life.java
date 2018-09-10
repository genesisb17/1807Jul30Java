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

public class Life implements InitializingBean, DisposableBean, BeanFactoryAware, BeanPostProcessor,
	BeanNameAware, ApplicationContextAware {
		
	
	private String circleOfLife;
	
	public Life() {
		System.out.println("This is the method that gets called in the beginning");
	}
	public String getCircleOfLife() {
		return circleOfLife;
	}
	public void setCircleOfLife(String circleOfLife) {
		this.circleOfLife = circleOfLife;
	}
	public Life(String circleOfLife) {
		super();
		this.circleOfLife = circleOfLife;
		
	}
	
	public void live() {
		System.out.println("Im ready to live.");
	}
	
	public void customInitMethod() {
		System.out.println("In custom init.");
	}
	
	public void customDestroyMethod() {
		System.out.println("In custom destroy.");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("in the after propset");
		
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("in the set app context");
	}
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("in the set bean name");
	}
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("in the post before init");
		return null;
	}
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("in the post process after init");
		return null;
		
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("in the bean factory");
	}
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("in destroy");
	}
}
