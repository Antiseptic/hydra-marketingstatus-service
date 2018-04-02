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

	/**
	 * Create a test marketing status in table to test on
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		log.info("setUp");
		testMarketingStatus = new MarketingStatus();
		testMarketingStatus.setMarketingStatusName(testName);
		testMarketingStatus = marketingStatusRepository.save(testMarketingStatus);
		testId = testMarketingStatus.getMarketingStatusId();
	}

	/**
	 * Remove test marketing status so that it doesn't cause problems with repeated runs 
	 * of the test and isn't left in database for production
	 */
	@After
	public void tearDown() {
		log.info("tearDown");
		if (marketingStatusRepository.findOne(testId) != null) {
			marketingStatusRepository.delete(testId);
		}
	}

	/**
	 * Test finding all marketing status's contained in a list
	 */
	@Test
	public void test1FindAll() {
		log.info("test1FindAll");
		List<MarketingStatus> status = marketingStatusRepository.findAll();
		assertNotNull(status);
	}
	
	/**
	 * Test finding a marketing status by name
	 */
	@Test
	public void test2FindByMarketingStatus() {
		log.info("test2FindByMarketingStatus");
		MarketingStatus ms = marketingStatusRepository.findOneByMarketingStatusName(testName);
		assertEquals(ms.getMarketingStatusId(), testId);
	}

	/**
	 * Test finding a markeing status by id
	 */
	@Test
	public void test21FindByMarketingStatusId() {
		log.info("test21FindByMarketingStatusId");
		MarketingStatus ms = marketingStatusRepository.findOne(testId);
		assertEquals(ms.getMarketingStatusName(), testMarketingStatus.getMarketingStatusName());
		assertEquals(ms.getMarketingStatusId(), testId);
	}
	
	/**
	 * Test updating a marketing status's name
	 */
	@Test
	public void test3UpdateMarketingStatus() {
		log.info("test3UpdateMarketingStatus");
		testMarketingStatus.setMarketingStatusName("updatedName");
		MarketingStatus updatedStatus = marketingStatusRepository.save(testMarketingStatus);
		assertEquals(updatedStatus, testMarketingStatus);
	}

	/**
	 * Ttest deleting a marketing status from table
	 */
	@Test
	public void test4DeleteMarketingStatus() {
		log.info("test4DeleteMarketingStatus");
		marketingStatusRepository.delete(testId);
		assertNull(marketingStatusRepository.findOne(testId));
	}
}
