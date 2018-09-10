package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import com.revature.repository.IceCreamRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RepositoryTest {
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager;
	
	@Autowired
	private IceCreamRepository iceCreamRepository;
	
	@Test
	public void iceCreamRepoShouldNotBeNull() {
		assertNotNull(iceCreamRepository);
	}
	
	@Test
	public void iceCreamRepoShouldBeEmpty() {
		assertEquals(iceCreamRepository.findAll().size(), 0);
	}
	
	@Test
	public void transactionManagerShouldNotBeNull() {
		assertNotNull(platformTransactionManager);
	}
	
	@Test 
	public void entityManagerShouldNotBeNull() {
		assertNotNull(entityManagerFactory);
	}
	
	@Test
	public void dataSourceShouldNotBeNull() {
		assertNotNull(dataSource);
	}
}
