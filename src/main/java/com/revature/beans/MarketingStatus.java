package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Beans for MarketingStatus table
 * @author Omowumi
 *
 */
@Entity
@Table(name = "CALIBER_MARKETING_STATUS")
public class MarketingStatus implements Serializable {
	private static final long serialVersionUID = -2759772290434666909L;

	@Id
	@Column(name = "MARKETING_STATUS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARKETING_STATUS_ID_SEQUENCE")
	@SequenceGenerator(name = "MARKETING_STATUS_ID_SEQUENCE", sequenceName = "MARKETING_STATUS_ID_SEQUENCE")
	private Integer marketingStatusId;
	
	@NotNull
	@Column(name = "MARKETING_STATUS_NAME")
	private String marketingStatusName;

	public MarketingStatus() { }

	public MarketingStatus(Integer marketingStatusId, String marketingStatusName) {
		this.marketingStatusId = marketingStatusId;
		this.marketingStatusName = marketingStatusName;
	}

	public Integer getMarketingStatusId() {
		return marketingStatusId;
	}

	public void setMarketingStatusId(Integer marketingStatusId) {
		this.marketingStatusId = marketingStatusId;
	}

	public String getMarketingStatusName() {
		return marketingStatusName;
	}

	public void setMarketingStatusName(String marketingStatusName) {
		this.marketingStatusName = marketingStatusName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marketingStatusId == null) ? 0 : marketingStatusId.hashCode());
		result = prime * result + ((marketingStatusName == null) ? 0 : marketingStatusName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarketingStatus other = (MarketingStatus) obj;
		if (marketingStatusId == null) {
			if (other.marketingStatusId != null)
				return false;
		} else if (!marketingStatusId.equals(other.marketingStatusId))
			return false;
		if (marketingStatusName == null) {
			if (other.marketingStatusName != null)
				return false;
		} else if (!marketingStatusName.equals(other.marketingStatusName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MarketingStatus [marketingStatusId=" + marketingStatusId + ", marketingStatusName="
				+ marketingStatusName + "]";
	}

	
	
	
	
}
