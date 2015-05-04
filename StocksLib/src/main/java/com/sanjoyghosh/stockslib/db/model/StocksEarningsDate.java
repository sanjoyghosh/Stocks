package com.sanjoyghosh.stockslib.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findStocksEarningsDateListByEarningsDate", query="SELECT sed FROM StocksEarningsDate sed WHERE sed.symbolEarningsDate.earningsDate = :earningsDate")

public class StocksEarningsDate implements Serializable {

	private static final long serialVersionUID = -2847989867724820579L;

	@EmbeddedId
	private SymbolEarningsDate	symbolEarningsDate;
	@Column
	private String				name;
	@Column
	private float				meanRecommendationThisWeek;
	@Column
	private int					numberOfBrokers;
	@Column
	private int					earningsReleaseTimeEnum;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public float getMeanRecommendationThisWeek() {
		return meanRecommendationThisWeek;
	}
	public void setMeanRecommendationThisWeek(float meanRecommendationThisWeek) {
		this.meanRecommendationThisWeek = meanRecommendationThisWeek;
	}
	
	
	public int getNumberOfBrokers() {
		return numberOfBrokers;
	}
	public void setNumberOfBrokers(int numberOfBrokers) {
		this.numberOfBrokers = numberOfBrokers;
	}
	
	
	public int getEarningsReleaseTimeEnum() {
		return earningsReleaseTimeEnum;
	}
	public void setEarningsReleaseTimeEnum(int earningsReleaseTimeEnum) {
		this.earningsReleaseTimeEnum = earningsReleaseTimeEnum;
	}
	
	
	public SymbolEarningsDate getSymbolEarningsDate() {
		return symbolEarningsDate;
	}
	public void setSymbolEarningsDate(SymbolEarningsDate symbolEarningsDate) {
		this.symbolEarningsDate = symbolEarningsDate;
	}
}
