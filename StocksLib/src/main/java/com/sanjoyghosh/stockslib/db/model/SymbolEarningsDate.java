package com.sanjoyghosh.stockslib.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SymbolEarningsDate implements Serializable {

	private static final long serialVersionUID = -4532908237155461258L;

	@Column
	private String	symbol;
	@Column
	private int		earningsDate;
	
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
	public int getEarningsDate() {
		return earningsDate;
	}
	public void setEarningsDate(int earningsDate) {
		this.earningsDate = earningsDate;
	}
}
