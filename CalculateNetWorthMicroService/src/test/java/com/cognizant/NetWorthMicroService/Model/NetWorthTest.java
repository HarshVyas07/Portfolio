package com.cognizant.NetWorthMicroService.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NetWorthTest {

	NetWorth asset=new NetWorth();
	@Test
	void testSetTid() {
		asset.settId(1);
		assertEquals(1,asset.gettId());
	}

	@Test
	void testSetAssetid() {
		asset.setAssetName("101");
		assertEquals("101",asset.getAssetName());
	}

	@Test
	void testSetPortfolioid() {
		asset.setPortfolioId(11);
		assertEquals(11,asset.getPortfolioId());
	}

	@Test
	void testSetType() {
		asset.setType("MF");
		assertEquals("MF",asset.getType());
	}

	@Test
	void testSetUnits() {
		asset.setUnits(10);
		assertEquals(10,asset.getUnits());
	}

	@Test
	void testAssetIntStringIntStringInt() {
		NetWorth asset1=new NetWorth(1, "101", 11, "MF", 10);
	}

	@Test
	void testAsset() {
		NetWorth asset1=new NetWorth();
	}

	@Test
	void testToString() {
		NetWorth asset2=new NetWorth(1, "101", 11, "MF", 10);
		assertEquals("NetWorth [tId=0, assetName=null, portfolioId=0, type=null, units=0]",asset.toString());
	}
	
}
