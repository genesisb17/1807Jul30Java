package com.ex.lifecycle;

import org.springframework.context.Lifecycle;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/*
	 * Spring Bean Lifecycle
	 * Instantiate
	 * Populate Properties
	 * setBeanName() -- from BeanNameAware
	 * setBeanFactory() -- from BeanFactoryAware
	 * setApplicationContext() -- from ApplicationContextAware
	 * PreInitialization -- Bean PostProcessors
	 * afterPropertiesSet -- InitializingBean
	 * init -- custom
	 * Post Initialization -- BeanPostProcessors
	 * 
	 * Bean is ready to use
	 * 
	 * destroy() -- DisposableBean
	 * destroy -- custom
	 */
	
	public static void main(String[] args) {
		//should only be used to expose lifecycle. not in practical applications
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Life life = (Life) context.getBean("life");
		life.live();
		context.close();
	}

}
