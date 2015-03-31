package com.sanjoyghosh.earnings.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findStoBySymbol", query="SELECT s FROM Stock s WHERE s.symbol = :symbol")

public class AnalystOpinionYahoo implements Serializable {

	private static final long serialVersionUID = -2882178203938395348L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Integer stockId;
		
	@Column
	private Date today;
	
	@Column
	private Float meanRecommendationThisWeek;

	@Column
	private Float meanRecommendationLastWeek;
	
	@Column
	private Float changeMeanRecommendation;
	
	@Column
	private Float meanTarget;
	
	@Column
	private Float medianTarget;
	
	@Column
	private Float highTarget;
	
	@Column 
	private Float lowTarget;
	
	@Column
	private Integer numberOfBrokers;
	
	@Column 
	private Integer strongBuyCurrentMonth;
	
	@Column
	private Integer strongBuyLastMonth;
	
	@Column
	private Integer strongBuyTwoMonthsAgo;
	
	@Column
	private Integer strongBuyThreeMonthsAgo;

	@Column
	private Integer buyCurrentMonth;

	@Column
	private Integer buyLastMonth;

	@Column
	private Integer buyTwoMonthsAgo;

	@Column
	private Integer buyThreeMonthsAgo;
	
	@Column
	private Integer holdCurrentMonth;
	
	@Column
	private Integer holdLastMonth;

	@Column
	private Integer holdTwoMonthsAgo;

	@Column
	private Integer holdThreeMonthsAgo;

	@Column
	private Integer underperformCurrentMonth;
	
	@Column
	private Integer underperformLastMonth;

	@Column
	private Integer underperformTwoMonthsAgo;

	@Column
	private Integer underperformThreeMonthsAgo;

	@Column
	private Integer sellCurrentMonth;
	
	@Column
	private Integer sellLastMonth;

	@Column
	private Integer sellTwoMonthsAgo;

	@Column
	private Integer sellThreeMonthsAgo;

	public AnalystOpinionYahoo() {}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public void setMeanRecommendationThisWeek(Float meanRecommendationThisWeek) {
		this.meanRecommendationThisWeek = meanRecommendationThisWeek;
	}

	public void setMeanRecommendationLastWeek(Float meanRecommendationLastWeek) {
		this.meanRecommendationLastWeek = meanRecommendationLastWeek;
	}

	public void setChangeMeanRecommendation(Float changeMeanRecommendation) {
		this.changeMeanRecommendation = changeMeanRecommendation;
	}

	public void setMeanTarget(Float meanTarget) {
		this.meanTarget = meanTarget;
	}

	public void setMedianTarget(Float medianTarget) {
		this.medianTarget = medianTarget;
	}

	public void setHighTarget(Float highTarget) {
		this.highTarget = highTarget;
	}

	public void setLowTarget(Float lowTarget) {
		this.lowTarget = lowTarget;
	}

	public void setStrongBuyCurrentMonth(Integer strongBuyCurrentMonth) {
		this.strongBuyCurrentMonth = strongBuyCurrentMonth;
	}

	public void setStrongBuyLastMonth(Integer strongBuyLastMonth) {
		this.strongBuyLastMonth = strongBuyLastMonth;
	}

	public void setStrongBuyTwoMonthsAgo(Integer strongBuyTwoMonthsAgo) {
		this.strongBuyTwoMonthsAgo = strongBuyTwoMonthsAgo;
	}

	public void setStrongBuyThreeMonthsAgo(Integer strongBuyThreeMonthsAgo) {
		this.strongBuyThreeMonthsAgo = strongBuyThreeMonthsAgo;
	}

	public void setBuyCurrentMonth(Integer buyCurrentMonth) {
		this.buyCurrentMonth = buyCurrentMonth;
	}

	public void setBuyLastMonth(Integer buyLastMonth) {
		this.buyLastMonth = buyLastMonth;
	}

	public void setBuyTwoMonthsAgo(Integer buyTwoMonthsAgo) {
		this.buyTwoMonthsAgo = buyTwoMonthsAgo;
	}

	public void setBuyThreeMonthsAgo(Integer buyThreeMonthsAgo) {
		this.buyThreeMonthsAgo = buyThreeMonthsAgo;
	}

	public void setHoldCurrentMonth(Integer holdCurrentMonth) {
		this.holdCurrentMonth = holdCurrentMonth;
	}

	public void setHoldLastMonth(Integer holdLastMonth) {
		this.holdLastMonth = holdLastMonth;
	}

	public void setHoldTwoMonthsAgo(Integer holdTwoMonthsAgo) {
		this.holdTwoMonthsAgo = holdTwoMonthsAgo;
	}

	public void setHoldThreeMonthsAgo(Integer holdThreeMonthsAgo) {
		this.holdThreeMonthsAgo = holdThreeMonthsAgo;
	}

	public void setUnderperformCurrentMonth(Integer underperformCurrentMonth) {
		this.underperformCurrentMonth = underperformCurrentMonth;
	}

	public void setUnderperformLastMonth(Integer underperformLastMonth) {
		this.underperformLastMonth = underperformLastMonth;
	}

	public void setUnderperformTwoMonthsAgo(Integer underperformTwoMonthsAgo) {
		this.underperformTwoMonthsAgo = underperformTwoMonthsAgo;
	}

	public void setUnderperformThreeMonthsAgo(Integer underperformThreeMonthsAgo) {
		this.underperformThreeMonthsAgo = underperformThreeMonthsAgo;
	}

	public void setSellCurrentMonth(Integer sellCurrentMonth) {
		this.sellCurrentMonth = sellCurrentMonth;
	}

	public void setSellLastMonth(Integer sellLastMonth) {
		this.sellLastMonth = sellLastMonth;
	}

	public void setSellTwoMonthsAgo(Integer sellTwoMonthsAgo) {
		this.sellTwoMonthsAgo = sellTwoMonthsAgo;
	}

	public void setSellThreeMonthsAgo(Integer sellThreeMonthsAgo) {
		this.sellThreeMonthsAgo = sellThreeMonthsAgo;
	}

	public Integer getNumberOfBrokers() {
		return numberOfBrokers;
	}

	public void setNumberOfBrokers(Integer numberOfBrokers) {
		this.numberOfBrokers = numberOfBrokers;
	}

	@Override
	public String toString() {
		return "AnalystOpinionYahoo [id=" + id + ", stockId=" + stockId
				+ ", today=" + today + ", meanRecommendationThisWeek="
				+ meanRecommendationThisWeek + ", meanRecommendationLastWeek="
				+ meanRecommendationLastWeek + ", changeMeanRecommendation="
				+ changeMeanRecommendation + ", meanTarget=" + meanTarget
				+ ", medianTarget=" + medianTarget + ", highTarget="
				+ highTarget + ", lowTarget=" + lowTarget
				+ ", numberOfBrokers=" + numberOfBrokers
				+ ", strongBuyCurrentMonth=" + strongBuyCurrentMonth
				+ ", strongBuyLastMonth=" + strongBuyLastMonth
				+ ", strongBuyTwoMonthsAgo=" + strongBuyTwoMonthsAgo
				+ ", strongBuyThreeMonthsAgo=" + strongBuyThreeMonthsAgo
				+ ", buyCurrentMonth=" + buyCurrentMonth + ", buyLastMonth="
				+ buyLastMonth + ", buyTwoMonthsAgo=" + buyTwoMonthsAgo
				+ ", buyThreeMonthsAgo=" + buyThreeMonthsAgo
				+ ", holdCurrentMonth=" + holdCurrentMonth + ", holdLastMonth="
				+ holdLastMonth + ", holdTwoMonthsAgo=" + holdTwoMonthsAgo
				+ ", holdThreeMonthsAgo=" + holdThreeMonthsAgo
				+ ", underperformCurrentMonth=" + underperformCurrentMonth
				+ ", underperformLastMonth=" + underperformLastMonth
				+ ", underperformTwoMonthsAgo=" + underperformTwoMonthsAgo
				+ ", underperformThreeMonthsAgo=" + underperformThreeMonthsAgo
				+ ", sellCurrentMonth=" + sellCurrentMonth + ", sellLastMonth="
				+ sellLastMonth + ", sellTwoMonthsAgo=" + sellTwoMonthsAgo
				+ ", sellThreeMonthsAgo=" + sellThreeMonthsAgo + "]";
	}
}
