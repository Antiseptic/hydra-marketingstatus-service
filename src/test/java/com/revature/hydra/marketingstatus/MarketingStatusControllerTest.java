package com.revature.hydra.marketingstatus;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.beans.MarketingStatus;
import com.revature.hydra.marketingstatus.application.MarketingStatusRepositoryServiceApplication;
import com.revature.hydra.marketingstatus.data.MarketingStatusRepository;

/**
 * 
 * @author Omowumi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarketingStatusRepositoryServiceApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarketingStatusControllerTest {
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Autowired
	private MarketingStatusRepository marketingStatusRepository;
	
	private MockMvc mockMvc;
	
	private MarketingStatus testMs;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		this.testMs = new MarketingStatus(0, "TEST STATUS");
		this.testMs = this.marketingStatusRepository.save(this.testMs);
	}

	@After
	public void tearDown() throws Exception {
		int testId = this.testMs.getMarketingStatusId();
		if (marketingStatusRepository.findOne(testId) != null) {
			marketingStatusRepository.delete(testId);
		}
	}

	@Test
	public void test1OneMSById() throws Exception {
		System.out.println("atest");
		this.mockMvc.perform(get("/one/marketingstatus/byid/" + this.testMs.getMarketingStatusId()))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
					.andExpect(jsonPath("$.marketingStatusId", is(this.testMs.getMarketingStatusId())))
					.andExpect(jsonPath("$.marketingStatusName", is(this.testMs.getMarketingStatusName())));
	}
	
	/*@Test
	public void test2AllMs() throws Exception*/

}
