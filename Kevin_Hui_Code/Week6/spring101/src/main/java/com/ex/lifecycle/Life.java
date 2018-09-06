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

public class Life implements InitializingBean, DisposableBean, BeanFactoryAware, BeanPostProcessor, BeanNameAware, ApplicationContextAware{
	private String circleOfLife;
	
	public Life() {
		System.out.println("CoL: NO ARGS CONSTR");
	}

	public Life(String circleOfLife) {
		super();
		this.circleOfLife = circleOfLife;
		System.out.println("CoL: 1 ARG CONSTR");
	}

	public String getCircleOfLife() {
		return circleOfLife;
	}

	public void setCircleOfLife(String circleOfLife) {
		System.out.println("CoL: SETTING PROPERTIES");
		this.circleOfLife = circleOfLife;
	}
	
	public void live() {
		System.out.println("CoL: IM READY TO LIVE!");
	}
	
	public void customInitMethod() {
		System.out.println("CoL: IN CUSTOM INIT");
	}
	
	public void customDestroyMethod() {
		System.out.println("CoL: IN CUSTOM DESTROY");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
