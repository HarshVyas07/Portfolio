package com.cognizant.NetWorthMicroService.Model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asset")
public class NetWorth {
	@Id
	private int tId;
	private String assetName;
	private int portfolioId;
	private String type;
	private int units;

	public NetWorth() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NetWorth(int tId, String assetName, int portfolioId, String type, int units) {
		super();
		this.tId = tId;
		this.assetName = assetName;
		this.portfolioId = portfolioId;
		this.type = type;
		this.units = units;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return "NetWorth [tId=" + tId + ", assetName=" + assetName + ", portfolioId=" + portfolioId + ", type=" + type
				+ ", units=" + units + "]";
	}
	
	
}
