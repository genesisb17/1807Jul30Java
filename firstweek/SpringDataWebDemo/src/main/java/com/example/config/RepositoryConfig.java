package com.example.config;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class RepositoryConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		Properties prop = getHibernateProperties();
		dataSource.setUsername(prop.getProperty("hibernate.connection.username"));
		dataSource.setPassword(prop.getProperty("hibernate.connection.password"));
		dataSource.setUsername(prop.getProperty("hibernate.connection.url"));
		dataSource.setDriverClassName(prop.getProperty("hibernate.connection.driver-class"));
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPackagesToScan(new String[] {"com.example.model"});
		emf.setDataSource(dataSource());
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		emf.setJpaProperties(getHibernateProperties());
		return emf;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(emf);
		return manager;
	}
	
	
	
	
	// Helper to get hibernate.properties
	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		try { prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
	} catch (IOException e) {
		e.printStackTrace();
	}
		return prop;
	}
}
