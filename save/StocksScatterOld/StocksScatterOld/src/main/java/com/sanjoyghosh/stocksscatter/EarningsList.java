package com.sanjoyghosh.stocksscatter;

import java.util.List;

import com.sanjoyghosh.stockslib.StocksLib;
import com.sanjoyghosh.stockslib.db.model.StocksEarningsDate;

public class EarningsList {

	private int 						earningsDateInt;
	private List<StocksEarningsDate>	earningsList;


	public EarningsList() {
		earningsList = StocksLib.findStocksEarningsDateListByEarningsDate(20150421);
	}
	
	
	public String send() {
		return ("success");
	}


	public int getEarningsDateInt() {
		return earningsDateInt;
	}

	public void setEarningsDateInt(int earningsDateInt) {
		this.earningsDateInt = earningsDateInt;
	}
	
	
	public List<StocksEarningsDate> getEarningsList() {
		return earningsList;
	}

	public void setEarningsList(List<StocksEarningsDate> earningsList) {
		this.earningsList = earningsList;
	}
}
