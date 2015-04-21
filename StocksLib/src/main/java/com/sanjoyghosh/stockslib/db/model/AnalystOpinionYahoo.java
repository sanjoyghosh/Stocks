package com.sanjoyghosh.stockslib.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@NamedQuery(name="findAnalystOpinionYahooByStockId", query="SELECT aoy FROM AnalystOpinionYahoo aoy WHERE aoy.stockId = :stockId ORDER BY createdDate DESC")

@Entity
public class AnalystOpinionYahoo extends AbstractStockBasedObject implements Serializable {

	private static final long serialVersionUID = -2882178203938395348L;

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
		return "AnalystOpinionYahoo [id=" + getId() + ", createdDate=" + getCreatedDate()
				+ ", stockId=" + getStockId() + ", meanRecommendationThisWeek="
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

	public boolean isTheSameAs(AnalystOpinionYahoo aoy) {
		if (this == aoy)
			return true;
		if (aoy == null)
			return false;
		if (getClass() != aoy.getClass())
			return false;
		if (buyCurrentMonth == null) {
			if (aoy.buyCurrentMonth != null)
				return false;
		} else if (!buyCurrentMonth.equals(aoy.buyCurrentMonth))
			return false;
		if (buyLastMonth == null) {
			if (aoy.buyLastMonth != null)
				return false;
		} else if (!buyLastMonth.equals(aoy.buyLastMonth))
			return false;
		if (buyThreeMonthsAgo == null) {
			if (aoy.buyThreeMonthsAgo != null)
				return false;
		} else if (!buyThreeMonthsAgo.equals(aoy.buyThreeMonthsAgo))
			return false;
		if (buyTwoMonthsAgo == null) {
			if (aoy.buyTwoMonthsAgo != null)
				return false;
		} else if (!buyTwoMonthsAgo.equals(aoy.buyTwoMonthsAgo))
			return false;
		if (changeMeanRecommendation == null) {
			if (aoy.changeMeanRecommendation != null)
				return false;
		} else if (!changeMeanRecommendation
				.equals(aoy.changeMeanRecommendation))
			return false;
		if (highTarget == null) {
			if (aoy.highTarget != null)
				return false;
		} else if (!highTarget.equals(aoy.highTarget))
			return false;
		if (holdCurrentMonth == null) {
			if (aoy.holdCurrentMonth != null)
				return false;
		} else if (!holdCurrentMonth.equals(aoy.holdCurrentMonth))
			return false;
		if (holdLastMonth == null) {
			if (aoy.holdLastMonth != null)
				return false;
		} else if (!holdLastMonth.equals(aoy.holdLastMonth))
			return false;
		if (holdThreeMonthsAgo == null) {
			if (aoy.holdThreeMonthsAgo != null)
				return false;
		} else if (!holdThreeMonthsAgo.equals(aoy.holdThreeMonthsAgo))
			return false;
		if (holdTwoMonthsAgo == null) {
			if (aoy.holdTwoMonthsAgo != null)
				return false;
		} else if (!holdTwoMonthsAgo.equals(aoy.holdTwoMonthsAgo))
			return false;
		if (lowTarget == null) {
			if (aoy.lowTarget != null)
				return false;
		} else if (!lowTarget.equals(aoy.lowTarget))
			return false;
		if (meanRecommendationLastWeek == null) {
			if (aoy.meanRecommendationLastWeek != null)
				return false;
		} else if (!meanRecommendationLastWeek
				.equals(aoy.meanRecommendationLastWeek))
			return false;
		if (meanRecommendationThisWeek == null) {
			if (aoy.meanRecommendationThisWeek != null)
				return false;
		} else if (!meanRecommendationThisWeek
				.equals(aoy.meanRecommendationThisWeek))
			return false;
		if (meanTarget == null) {
			if (aoy.meanTarget != null)
				return false;
		} else if (!meanTarget.equals(aoy.meanTarget))
			return false;
		if (medianTarget == null) {
			if (aoy.medianTarget != null)
				return false;
		} else if (!medianTarget.equals(aoy.medianTarget))
			return false;
		if (numberOfBrokers == null) {
			if (aoy.numberOfBrokers != null)
				return false;
		} else if (!numberOfBrokers.equals(aoy.numberOfBrokers))
			return false;
		if (sellCurrentMonth == null) {
			if (aoy.sellCurrentMonth != null)
				return false;
		} else if (!sellCurrentMonth.equals(aoy.sellCurrentMonth))
			return false;
		if (sellLastMonth == null) {
			if (aoy.sellLastMonth != null)
				return false;
		} else if (!sellLastMonth.equals(aoy.sellLastMonth))
			return false;
		if (sellThreeMonthsAgo == null) {
			if (aoy.sellThreeMonthsAgo != null)
				return false;
		} else if (!sellThreeMonthsAgo.equals(aoy.sellThreeMonthsAgo))
			return false;
		if (sellTwoMonthsAgo == null) {
			if (aoy.sellTwoMonthsAgo != null)
				return false;
		} else if (!sellTwoMonthsAgo.equals(aoy.sellTwoMonthsAgo))
			return false;
		if (getStockId() == null) {
			if (aoy.getStockId() != null)
				return false;
		} else if (!getStockId().equals(aoy.getStockId()))
			return false;
		if (strongBuyCurrentMonth == null) {
			if (aoy.strongBuyCurrentMonth != null)
				return false;
		} else if (!strongBuyCurrentMonth.equals(aoy.strongBuyCurrentMonth))
			return false;
		if (strongBuyLastMonth == null) {
			if (aoy.strongBuyLastMonth != null)
				return false;
		} else if (!strongBuyLastMonth.equals(aoy.strongBuyLastMonth))
			return false;
		if (strongBuyThreeMonthsAgo == null) {
			if (aoy.strongBuyThreeMonthsAgo != null)
				return false;
		} else if (!strongBuyThreeMonthsAgo
				.equals(aoy.strongBuyThreeMonthsAgo))
			return false;
		if (strongBuyTwoMonthsAgo == null) {
			if (aoy.strongBuyTwoMonthsAgo != null)
				return false;
		} else if (!strongBuyTwoMonthsAgo.equals(aoy.strongBuyTwoMonthsAgo))
			return false;
		if (underperformCurrentMonth == null) {
			if (aoy.underperformCurrentMonth != null)
				return false;
		} else if (!underperformCurrentMonth
				.equals(aoy.underperformCurrentMonth))
			return false;
		if (underperformLastMonth == null) {
			if (aoy.underperformLastMonth != null)
				return false;
		} else if (!underperformLastMonth.equals(aoy.underperformLastMonth))
			return false;
		if (underperformThreeMonthsAgo == null) {
			if (aoy.underperformThreeMonthsAgo != null)
				return false;
		} else if (!underperformThreeMonthsAgo
				.equals(aoy.underperformThreeMonthsAgo))
			return false;
		if (underperformTwoMonthsAgo == null) {
			if (aoy.underperformTwoMonthsAgo != null)
				return false;
		} else if (!underperformTwoMonthsAgo
				.equals(aoy.underperformTwoMonthsAgo))
			return false;
		return true;
	}
}
