package com.revature.hydra.marketingstatus.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.MarketingStatus;

/**
 * MarketingStatusRepository Data Access Object with various methods to communicate with database
 * @author Omowumi
 *
 */
@Repository
public interface MarketingStatusRepository extends JpaRepository<MarketingStatus, Integer> {
	/**
	 * Find all MarketingStatus's
	 * 
	 * @return List<MarketingStatus>
	 */
	List<MarketingStatus> findAll();
	
	/**
	 * Find a MarketingStatus by MarketingStatusName
	 * 
	 * @param marketingStatusName
	 * @return
	 */
	MarketingStatus findOneByMarketingStatusName(String marketingStatusName);
}
