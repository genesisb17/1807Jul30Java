package com.iantimothyjohnson.notes.week7.config;

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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.iantimothyjohnson.notes.week7.repository")
public class RepositoryConfig {
	@Bean
	// @Profile("test")
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
		emf.setPackagesToScan("com.iantimothyjohnson.notes.week7.model");
		emf.setDataSource(dataSource());
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(adapter);
		emf.setJpaProperties(getHibernateProperties());
		return emf;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager manager = new JpaTransactionManager(emf);
		manager.setEntityManagerFactory(emf);
		return manager;
	}

	/**
	 * Helper method to retrieve our hibernate.properties file.
	 */
	private Properties getHibernateProperties() {
		try {
			Properties props = new Properties();
			props.load(this.getClass().getResourceAsStream("/hibernate.properties"));
			return props;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
