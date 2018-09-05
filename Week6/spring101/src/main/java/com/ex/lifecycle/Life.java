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

public class Life implements InitializingBean, DisposableBean,
	BeanFactoryAware, BeanPostProcessor, BeanNameAware, 
	ApplicationContextAware {
	
	/*
	 * Spring Bean Lifecycle
	 * 
	 * Instantiate
	 * Populate
	 * 
	 */
	
	private String circleOfLife;

	public Life() {}
	
	public Life(String circleOfLife) {
		super();
		this.circleOfLife = circleOfLife;
	}

	public String getCircleOfLife() {
		return circleOfLife;
	}

	public void setCircleOfLife(String circleOfLife) {
		this.circleOfLife = circleOfLife;
	}
	
	public void live() {
		System.out.println("I'm ready to live");
	}
	
	public void customInitMethod() {
		System.out.println("In custom init");
	}
	
	public void customDestroyMethod() {
		System.out.println("In custom destroy");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setting application context");
		
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("set the Bean name");
		
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("posting process before initialization");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("posting process after initialization");
		return null;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setting bean factory");
		
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
