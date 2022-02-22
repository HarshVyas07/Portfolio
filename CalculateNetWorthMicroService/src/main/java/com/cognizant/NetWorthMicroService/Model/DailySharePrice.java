package com.cognizant.NetWorthMicroService.Model;

public class DailySharePrice {

	private String stockId;
	private String stockName;
	private double stockValue;

	public DailySharePrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DailySharePrice(String stockId, String stockName, double stockValue) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockValue = stockValue;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getStockValue() {
		return stockValue;
	}

	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}

	@Override
	public String toString() {
		return "DailySharePrice [stockId=" + stockId + ", stockName=" + stockName + ", stockValue=" + stockValue + "]";
	}
}
