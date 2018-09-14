package com.revature.config;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //tells ioc that this class contains bean definitions
@EnableTransactionManagement
@EnableJpaRepositories("com.example.repository")
public class RepositoryConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		Properties props = getHibernateProperties();
		dataSource.setUsername(props.getProperty("hibernate.connection.username"));
		dataSource.setPassword(props.getProperty("hibernate.connection.password"));
		dataSource.setUrl(props.getProperty("hibernate.connection.url"));
		dataSource.setDriverClassName(props.getProperty("hibernate.connection.driver-class"));
		
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPackagesToScan(new String[] { "com.revature.model" });
		emf.setDataSource(dataSource());
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(adapter);
		emf.setJpaProperties(getHibernateProperties());
		
		return emf;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(emf);
		
		return manager;
	}
	
	//helper method to retrieve our hibernate.properties file
	private Properties getHibernateProperties() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return props;
	}
}
