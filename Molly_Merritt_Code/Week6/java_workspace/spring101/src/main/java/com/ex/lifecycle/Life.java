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
	BeanFactoryAware, BeanPostProcessor, BeanNameAware, ApplicationContextAware {
	
	/*
	 * Spring Bean Lifecycle
	 * 
	 * Instantiate
	 * Populate Properties
	 * setBeanName() -- from BeanNameAware
	 * setBeanFactory() -- from BeanFactoryAware
	 * setApplicationContext() -- from ApplicationContextAware
	 * PreInitialization -- Bean PostProcessors
	 * afterPropertiesSet -- InitializingBean
	 * 
	 */
	
	private String circleOfLife;
	
	public Life() {}

	public Life(String circleOfLife) {
		super();
		this.circleOfLife = circleOfLife;
	}

	public String getCircleOfLife() {
		System.out.println("SETTING PROPERTIES");
		return circleOfLife;
	}

	public void setCircleOfLife(String circleOfLife) {
		this.circleOfLife = circleOfLife;
	}
	
	public void live() {
		System.out.println("IM READY TO LIVE");
	}
	
	public void customInitMethod() {
		System.out.println("IN CUSTOM INIT");
	}
	
	public void customDestroyMethod() {
		System.out.println("IN CUSTOM DESTROY");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("IN SET APPLICATION CONTEXT");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("IN SET BEAN NAME");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("IN POST PROCESS BEFORE INITIALIZATION");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("IN POST PROCESS AFTER INITIALIZATION");
		return null;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("IN SET BEAN FACTORY");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("IN DESTROY");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("IN AFTER PROPERTIES SET");
	}

}
