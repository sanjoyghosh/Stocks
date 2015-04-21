package com.sanjoyghosh.stockslib.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@NamedQuery(name="findStockBySymbol", query="SELECT s FROM Stock s WHERE s.symbol = :symbol")

@Entity
public class Stock extends AbstractDBObject implements Serializable {

	private static final long serialVersionUID = 105074516845026983L;
	
	@Column
	private String name;
	
	@Column
	private String symbol;
	
	
	public Stock() {}
	
	@Override
	public String toString() {
		return "Stock [id=" + getId() + ", createdDate=" + getCreatedDate() + ", name=" + name + ", symbol=" + symbol + "]";
	}

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
