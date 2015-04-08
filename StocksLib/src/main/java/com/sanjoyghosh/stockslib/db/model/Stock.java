package com.sanjoyghosh.stockslib.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findStockBySymbol", query="SELECT s FROM Stock s WHERE s.symbol = :symbol")

public class Stock implements Serializable {

	private static final long serialVersionUID = 105074516845026983L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String symbol;
	
	public Stock() {}
	
	public Stock(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", symbol=" + symbol
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}
}
