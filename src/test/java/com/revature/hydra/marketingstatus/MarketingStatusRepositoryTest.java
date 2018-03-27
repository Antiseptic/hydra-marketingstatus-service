package com.revature.hydra.marketingstatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.beans.MarketingStatus;
import com.revature.hydra.marketingstatus.application.MarketingStatusRepositoryServiceApplication;
import com.revature.hydra.marketingstatus.data.MarketingStatusRepository;

/**
 * JUnit class to test the Repository methods
 * @author Omowumi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarketingStatusRepositoryServiceApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarketingStatusRepositoryTest {
	private static final Logger log = Logger.getLogger(MarketingStatusRepositoryTest.class);
	
	@Autowired
	MarketingStatusRepository marketingStatusRepository;
	
	MarketingStatus testMarketingStatus;
	
	Integer testId;
	
	String testName = "testMarketingStatus";

	@Before
	public void setUp() throws Exception {
		log.info("setUp");
		testMarketingStatus = new MarketingStatus();
		testMarketingStatus.setMarketingStatusName(testName);
		testMarketingStatus = marketingStatusRepository.save(testMarketingStatus);
		testId = testMarketingStatus.getMarketingStatusId();
	}

	@After
	public void tearDown() throws Exception {
		log.info("tearDown");
		if (marketingStatusRepository.findOne(testId) != null) {
			marketingStatusRepository.delete(testId);
		}
	}

	@Test
	public void test1FindAll() {
		log.info("test1FindAll");
		List<MarketingStatus> status = marketingStatusRepository.findAll();
		assertNotNull(status);
	}
	
	@Test
	public void test2FindByMarketingStatus() {
		log.info("test2FindByMarketingStatus");
		MarketingStatus ms = marketingStatusRepository.findOneByMarketingStatusName(testName);
		assertEquals(ms.getMarketingStatusId(), testId);
	}
	
	@Test
	public void test3UpdateMarketingStatus() {
		log.info("test3UpdateMarketingStatus");
		testMarketingStatus.setMarketingStatusName("updatedName");
		MarketingStatus updatedStatus = marketingStatusRepository.save(testMarketingStatus);
		assertEquals(updatedStatus, testMarketingStatus);
	}

	@Test
	public void test4DeleteMarketingStatus() {
		log.info("test4DeleteMarketingStatus");
		marketingStatusRepository.delete(testId);
		assertNull(marketingStatusRepository.findOne(testId));
	}
}
