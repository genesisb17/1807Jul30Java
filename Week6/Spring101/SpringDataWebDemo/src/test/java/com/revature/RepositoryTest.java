package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void transactionManagerShouldNotBeNUll() {
		assertNotNull(platformTransactionManager);
	}
	
	@Test
	public void dataSourceShouldNotBeNull() {
		assertNotNull(dataSource);
	}
	
	@Test
	public void iceCreamRepoShouldNotBeNull() {
		assertNotNull(iceCreamRepository);
	}
	
	@Test
	public void iceCreamRepoShouldBeEmpty() {
		assertEquals(iceCreamRepository.findAll().size(), 0);
	}
	
	@Test
	public void entityManagerShouldNotBeNull() {
		
	}
}
