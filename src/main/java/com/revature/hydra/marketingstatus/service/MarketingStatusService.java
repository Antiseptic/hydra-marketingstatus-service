package com.revature.hydra.marketingstatus.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.MarketingStatus;
import com.revature.hydra.marketingstatus.data.MarketingStatusRepository;

/**
 * Marketing Status Service
 * 
 * Marketing status services implementation of communication with MarketingStatusRepository
 *  
 * @author Omowumi
 *
 */
@Service
public class MarketingStatusService {

	@Autowired
	private MarketingStatusRepository marketingStatusRepository;
	
	/**
	 * Get all marketing status's in a list
	 * @return List<MarketingStatus>
	 */
	public List<MarketingStatus> findAll() {
		List<MarketingStatus> lms = marketingStatusRepository.findAll();
		
		return lms;
	}
	
	/**
	 * Get all marketing status's in a mapping
	 * @return Map<Integer, MarketingStatus>
	 */
	public Map<Integer, MarketingStatus> findAllStatus() {
		List<MarketingStatus> lms = marketingStatusRepository.findAll();
		return createMapping(lms);
	}
	
	public MarketingStatus findOneById(Integer id) {
		return marketingStatusRepository.findOne(id);
	}
	
	/**
	 * Get a single MarketingStatus object
	 * @param marketingStatusName
	 * @return MarketingStatus
	 */
	public MarketingStatus findOneByMarketingStatus(String marketingStatusName) {
		MarketingStatus ms = marketingStatusRepository.findOneByMarketingStatusName(marketingStatusName);
		
		return ms;
	}
	
	/**
	 * Add a new marketing status
	 * @param marketingStatusName
	 */
	public void addMarketingStatus(String marketingStatusName) {
		MarketingStatus ms = new MarketingStatus();
		ms.setMarketingStatusName(marketingStatusName);
		marketingStatusRepository.save(ms);
	}
	
	/**
	 * Update a marketing status name
	 * @param marketingStatus
	 */
	public void updateMarketingStatus(MarketingStatus marketingStatus) {
		marketingStatusRepository.save(marketingStatus);
	}
	
	/**
	 * Delete a marketing status by marketingStatusId
	 * @param marketingStatusId
	 */
	public void deleteMarketingStatusById(Integer marketingStatusId) {
		marketingStatusRepository.delete(marketingStatusId);
	}
	
	/**
	 * Delete a marketing status object
	 * @param marketingStatus
	 */
	public void deleteMarketingStatus(MarketingStatus marketingStatus) {
		marketingStatusRepository.delete(marketingStatus);
	}
	
	/**
	 * Helper function to create marketingStatusId, marketingStatus mapping
	 * @param lms
	 * @return Map<Integer, MarketingStatus>
	 */
	private Map<Integer, MarketingStatus> createMapping(List<MarketingStatus> lms) {
		Map<Integer, MarketingStatus> map = new HashMap<>();

		if (lms != null) {
			for (MarketingStatus ms : lms) {
				map.put(ms.getMarketingStatusId(), ms);
			}
		}

		return map;
	}
}
