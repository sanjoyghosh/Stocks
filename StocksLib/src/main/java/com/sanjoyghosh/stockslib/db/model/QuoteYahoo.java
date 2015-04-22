package com.sanjoyghosh.stockslib.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class QuoteYahoo extends AbstractStockBasedObject implements Serializable {

	private static final long serialVersionUID = 7066453402256758170L;

	@Column
	private Float price;
	
	@Column
	private Float previousClose;
	
	@Column
	private Float open;
	
	@Column
	private Float oneYearTarget;
	
	@Column
	private Float dayRangeLow;
	
	@Column
	private Float dayRangeHigh;
	
	@Column
	private Float fiftyTwoWeekRangeLow;
	
	@Column
	private Float fiftyTwoWeekRangeHigh;
	
	@Column
	private Integer volume;
	
	@Column
	private Integer threeMonthAverageVolume;
	
	@Column
	private Long marketCap;
	
	
	public QuoteYahoo() {}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public Float getPreviousClose() {
		return previousClose;
	}


	public void setPreviousClose(Float previousClose) {
		this.previousClose = previousClose;
	}


	public Float getOpen() {
		return open;
	}


	public void setOpen(Float open) {
		this.open = open;
	}


	public Float getOneYearTarget() {
		return oneYearTarget;
	}


	public void setOneYearTarget(Float oneYearTarget) {
		this.oneYearTarget = oneYearTarget;
	}


	public Float getDayRangeLow() {
		return dayRangeLow;
	}


	public void setDayRangeLow(Float dayRangeLow) {
		this.dayRangeLow = dayRangeLow;
	}


	public Float getDayRangeHigh() {
		return dayRangeHigh;
	}


	public void setDayRangeHigh(Float dayRangeHigh) {
		this.dayRangeHigh = dayRangeHigh;
	}


	public Float getFiftyTwoWeekRangeLow() {
		return fiftyTwoWeekRangeLow;
	}


	public void setFiftyTwoWeekRangeLow(Float fiftyTwoWeekRangeLow) {
		this.fiftyTwoWeekRangeLow = fiftyTwoWeekRangeLow;
	}


	public Float getFiftyTwoWeekRangeHigh() {
		return fiftyTwoWeekRangeHigh;
	}


	public void setFiftyTwoWeekRangeHigh(Float fiftyTwoWeekRangeHigh) {
		this.fiftyTwoWeekRangeHigh = fiftyTwoWeekRangeHigh;
	}


	public Integer getVolume() {
		return volume;
	}


	public void setVolume(Integer volume) {
		this.volume = volume;
	}


	public Integer getThreeMonthAverageVolume() {
		return threeMonthAverageVolume;
	}


	public void setThreeMonthAverageVolume(Integer threeMonthAverageVolume) {
		this.threeMonthAverageVolume = threeMonthAverageVolume;
	}


	public Long getMarketCap() {
		return marketCap;
	}


	public void setMarketCap(Long marketCap) {
		this.marketCap = marketCap;
	}


	@Override
	public String toString() {
		return "QuoteYahoo [price=" + price + ", previousClose="
				+ previousClose + ", open=" + open + ", oneYearTarget="
				+ oneYearTarget + ", dayRangeLow=" + dayRangeLow
				+ ", dayRangeHigh=" + dayRangeHigh + ", fiftyTwoWeekRangeLow="
				+ fiftyTwoWeekRangeLow + ", fiftyTwoWeekRangeHigh="
				+ fiftyTwoWeekRangeHigh + ", volume=" + volume
				+ ", threeMonthAverageVolume=" + threeMonthAverageVolume
				+ ", marketCap=" + marketCap + "]";
	}
}
