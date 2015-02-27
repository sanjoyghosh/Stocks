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
@NamedQuery(name="findStockBySymbol", query="SELECT s FROM Stock s WHERE s.symbol = :symbol")

public class EarningsData implements Serializable {

	private static final long serialVersionUID = -2882178203938395348L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Integer stockId;
	
	@Column
	private Date earningsDate;
	
	@Column
	private Date today;
	
	@Column
	private Float price;
	
	@Column
	private Float yahooPriceTarget;

	@Column
	private Float marketwatchPriceTarget;
	
	@Column
	private Float price1YearLow;
	
	@Column
	private Float price1YearHigh;
	
	@Column
	private Integer marketCap;
	
	@Column
	private Float yahooAnalystOpinionThisWeek;
	
	@Column 
	private Float yahooAnalystOpinionLastWeek;
	
	@Column 
	private Float marketwatchAnalystOpinion;
	
	@Column
	private Integer yahooNumberAnalysts;
	
	@Column
	private Integer yahooNumberAnalystsStrongBuy;
	
	@Column
	private Integer yahooNumberAnalystsBuy;

	@Column
	private Integer yahooNumberAnalystsHold;

	@Column
	private Integer yahooNumberAnalystsUnderperform;

	@Column
	private Integer yahooNumberAnalystsSell;

	@Column
	private Integer marketwatchNumberAnalysts;
	
	@Column
	private Integer marketwatchNumberAnalystsStrongBuy;
	
	@Column
	private Integer marketwatchNumberAnalystsBuy;

	@Column
	private Integer marketwatchNumberAnalystsHold;

	@Column
	private Integer marketwatchNumberAnalystsUnderperform;

	@Column
	private Integer marketwatchNumberAnalystsSell;

	public EarningsData(int id, int stockId, Date earningsDate, Date today, 
		float price, float yahooPriceTarget, float marketwatchPriceTarget, 
		float price1YearLow, float price1YearHigh, int marketCap,
		float yahooAnalystOpinionThisWeek, float yahooAnalystOpinionLastWeek, float marketwatchAnalystOpinion,
		int yahooNumberAnalysts, int yahooNumberAnalystsStrongBuy, int yahooNumberAnalystsBuy, 
		int yahooNumberAnalystsHold, int yahooNumberAnalystsUnderperform, int yahooNumberAnalystsSell,
		int marketwatchNumberAnalysts, int marketwatchNumberAnalystsStrongBuy, int marketwatchNumberAnalystsBuy, 
		int marketwatchNumberAnalystsHold, int marketwatchNumberAnalystsUnderperform, int marketwatchNumberAnalystsSell) {
		
		this.id = id;
		this.stockId = stockId;
		this.earningsDate = earningsDate;
		this.today = today;
		this.price = price;
		this.yahooPriceTarget = yahooPriceTarget;
		this.price1YearLow = price1YearLow;
		this.price1YearHigh = price1YearHigh;
		this.marketCap = marketCap;
		this.yahooAnalystOpinionThisWeek = yahooAnalystOpinionThisWeek;
		this.yahooAnalystOpinionLastWeek = yahooAnalystOpinionLastWeek;
		this.marketwatchAnalystOpinion = marketwatchAnalystOpinion;
		this.yahooNumberAnalysts = yahooNumberAnalysts;
		this.yahooNumberAnalystsStrongBuy = yahooNumberAnalystsStrongBuy;
		this.yahooNumberAnalystsBuy = yahooNumberAnalystsBuy;
		this.yahooNumberAnalystsHold = yahooNumberAnalystsHold;
		this.yahooNumberAnalystsUnderperform = yahooNumberAnalystsUnderperform;
		this.yahooNumberAnalystsSell = yahooNumberAnalystsSell;
		this.yahooAnalystOpinionThisWeek = yahooAnalystOpinionThisWeek;
		this.yahooAnalystOpinionLastWeek = yahooAnalystOpinionLastWeek;
		this.marketwatchNumberAnalysts = marketwatchNumberAnalysts;
		this.marketwatchNumberAnalystsStrongBuy = marketwatchNumberAnalystsStrongBuy;
		this.marketwatchNumberAnalystsBuy = marketwatchNumberAnalystsBuy;
		this.marketwatchNumberAnalystsHold = marketwatchNumberAnalystsHold;
		this.marketwatchNumberAnalystsUnderperform = marketwatchNumberAnalystsUnderperform;
		this.marketwatchNumberAnalystsSell = marketwatchNumberAnalystsSell;
	}
}
