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

public class Life implements InitializingBean, DisposableBean, BeanFactoryAware, BeanPostProcessor, BeanNameAware, ApplicationContextAware {

	private String col;
	
	public Life() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Life(String col) {
		super();
		this.col = col;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		System.out.println("SETTING PROPERTIES");
		this.col = col;
	}

	public void live() {
		System.out.println("READY FOR ACTION!!!!!!!");
	}
	
	public void cstmInit() {
		System.out.println("IN CUSTOM INIT");
	}
	
	public void cstmDestroy() {
		System.out.println("RUN AWAY!!!!!!!!");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
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
