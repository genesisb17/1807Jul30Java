package com.iantimothyjohnson.notes.week7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;

import com.iantimothyjohnson.notes.week7.repository.IceCreamRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataWebDemoApplicationTests {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private EntityManagerFactory emf;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Autowired
	private IceCreamRepository iceCreamRepository;

	@Test
	public void dataSourceShouldNotBeNull() {
		assertNotNull(dataSource);
	}
	
	@Test
	public void entityManagerFactoryShouldNotBeNull() {
		assertNotNull(emf);
	}
	
	@Test
	public void transactionManagerShouldNotBeNull() {
		assertNotNull(transactionManager);
	}
	
	@Test
	public void iceCreamRepoShouldNotBeNull() {
		assertNotNull(iceCreamRepository);
	}
	
	@Test
	public void iceCreamRepoShouldBeEmpty() {
		assertEquals(iceCreamRepository.findAll().size(), 0);
	}
}
