package com.cognizant.NetWorthMicroService.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MutualFundDetailsTest {

	MutualFundNAV mutualFund=new MutualFundNAV();
	@Test
	void testSetMutualFundId() {
		mutualFund.setMutualFundId("101");
		assertEquals("101", mutualFund.getMutualFundId());
	}

	@Test
	void testSetMutualFundName() {
		mutualFund.setMutualFundName("abc");
		assertEquals("abc", mutualFund.getMutualFundName());
	}

	@Test
	void testSetMutualFundValue() {
		mutualFund.setMutualFundValue(10.0);
		assertEquals(10.0, mutualFund.getMutualFundValue());
	}

	@Test
	void testMutualFundDetailsStringStringDouble() {
		MutualFundNAV mfd=new MutualFundNAV("101", "AXIS", 10.0);
	}

	@Test
	void testMutualFundDetails() {
		MutualFundNAV mfd=new MutualFundNAV();
	}

	@Test
	void testToString() {
		MutualFundNAV mfd=new MutualFundNAV("101", "AXIS", 10.0);
		assertEquals("MutualFundDetails [mutualFundId=101, mutualFundName=AXIS, mutualFundValue=10.0]", mfd.toString());
	}
}
