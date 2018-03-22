package com.revature.hydra.marketingstatus.service;

import java.util.List;

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
	
	public List<MarketingStatus> findAll() {
		List<MarketingStatus> lms = marketingStatusRepository.findAll();
		
		return lms;
	}
}
