package com.test.main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Lifecycle implements 
InitializingBean, DisposableBean, BeanFactoryAware, BeanPostProcessor,
BeanNameAware, ApplicationContextAware {

	/*
	 * A spring bean is managed by the IoC/Spring container
	 * Whenever a bean is declared in the Spring bean configuration file, 
	 * the container will find it and do the following steps to make it available
	 * for the application 
	 * 
	 * 
	 */
	static {
		System.out.println("IN STATIC BLOCK. CLASS LOADED");
	}
	String message;
	
	//must always have no-args constructor 
	public Lifecycle() {
		System.out.println("IN NO ARGS CONSTRUCTOR");
	}
	
	public Lifecycle(String message) {
		super();
		System.out.println("CONSTRUCTING BEAN WITH MESSAGE: " + message);
		this.message = message;
	}
	
	

	public String getMessage() {
		return message;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		/*
		 * Callback that supplies the owning factory to a bean instance
		 */
		
		System.out.println("SET BEAN FACTORY");
	}


	public void setMessage(String message) {
		System.out.println("IN SETTER. MESSAGE: " + message);
		this.message = message;
	}



	@Override
	public void setBeanName(String name) {
		/*
		 * Set the name of the bean in the bean factory that created it
		 */
		System.out.println("SET BEAN NAME");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("POST PROCESS BEFORE INITIALIZATION");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("POST PROCESS AFTER INITIALIZATION");
		return null;
	}

	//pre-destroy
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DISPOSABLE BEAN DESTROY");
		
	}
	


	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AFTER PROPERTIES SET");
		
	}
	
	public void initializeBean() {
		System.out.println("CUSTOM INITIALIZING BEAN");
	}
	
	public void destroyBean() {
		System.out.println(" CUSTOM DESTROYING BEAN");
	}
	
	void doThings() {
		System.out.println("CLASS HAS LOADED. DOING THINGS");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		/*
		 * method from ApplicationContextedAware interface
		 * 		to be implemented by any object that wishes to be notified of the 
		 * 		ApplicationContext that it runs in 
		 */
		System.out.println("SET APPLICATION CONTEXT");
	}

}
