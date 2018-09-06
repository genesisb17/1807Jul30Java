package com.iantimothyjohnson.notes.week6.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// This bean will illustrate the parts of the Spring bean lifecycle.
public class Life implements InitializingBean, DisposableBean, BeanFactoryAware, BeanPostProcessor, BeanNameAware,
		ApplicationContextAware {
	private String circleOfLife;

	public Life() {
		System.out.println("In Life no-args constructor.");
	}

	public Life(String circleOfLife) {
		System.out.println("In Life one-arg constructor.");
		this.circleOfLife = circleOfLife;
	}

	public String getCircleOfLife() {
		return circleOfLife;
	}

	public void setCircleOfLife(String circleOfLife) {
		System.out.println("In circleOfLife setter.");
		this.circleOfLife = circleOfLife;
	}

	public void live() {
		System.out.println("I'm ready to live!");
	}

	public void customInitMethod() {
		System.out.println("In custom init.");
	}

	public void customDestroyMethod() {
		System.out.println("In custom destroy.");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("Application context set: " + applicationContext);
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Bean name set: " + name);
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean getting post-processed before initialization: " + bean + "; name: " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean getting post-processed after initialization: " + bean + "; name: " + beanName);
		return bean;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Set bean factory: " + beanFactory);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying bean.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After properties set.");
	}
}
