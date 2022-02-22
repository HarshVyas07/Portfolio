package com.cognizant.NetWorthMicroService.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class StockDetailsTest {
	DailySharePrice shareDetails=new DailySharePrice();
	
	@Test
	void testGetShareId() {
		shareDetails.setStockId("101");
		assertEquals("101", shareDetails.getStockId());
	}

	@Test
	void testGetShareName() {
		shareDetails.setStockName("abc");
		assertEquals("abc", shareDetails.getStockName());
	}

	@Test
	void testGetShareValue() {
		shareDetails.setStockValue(10.0);
		assertEquals(10.0, shareDetails.getStockValue());
	}
	
	@Test
	void testStockDetailsStringStringDouble() {
		DailySharePrice shareDetails=new DailySharePrice("101", "abc", 10.0);
		assertEquals("101", shareDetails.getStockId());
		assertEquals("abc", shareDetails.getStockName());
		assertEquals(10.0, shareDetails.getStockValue());
	}

	@Test
	void testStockDetails() {
		DailySharePrice shareDetails=new DailySharePrice();
	}

	@Test
	void testToString() {
		DailySharePrice shareDetails=new DailySharePrice("101", "abc", 10.0);
		assertEquals("DailySharePrice [stockId=101, stockName=abc, stockValue=10.0]", shareDetails.toString());
		
	}

}
