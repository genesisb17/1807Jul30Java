package com.revature;

import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import com.revature.config.RepositoryConfig;
import com.revature.repository.IceCreamRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes=RepositoryConfig.class)
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
		Assert.assertNotNull(iceCreamRepository);
	}
	
	@Test
	public void iceCreamRepoShouldBeEmpty() {
//		Assert.assertEquals(iceCreamRepository.findAll(), 0);
	}
	
	@Test
	public void dataSourceShouldNotBeNull() {
		Assert.assertNotNull(dataSource);
	}

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
