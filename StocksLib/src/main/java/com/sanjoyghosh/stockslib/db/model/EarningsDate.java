package com.sanjoyghosh.stockslib.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EarningsDate implements Serializable {

	private static final long serialVersionUID = 4263519372478222266L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Integer stockId;
	
	@Column
	private Integer earningsDate;
	
	@Column
	private Integer earningsReleaseTimeEnum;
	
	
	public EarningsDate() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Integer getEarningsDate() {
		return earningsDate;
	}

	public void setEarningsDate(Integer earningsDate) {
		this.earningsDate = earningsDate;
	}

	public Integer getEarningsReleaseTimeEnum() {
		return earningsReleaseTimeEnum;
	}

	public void setEarningsReleaseTimeEnum(Integer earningsReleaseTimeEnum) {
		this.earningsReleaseTimeEnum = earningsReleaseTimeEnum;
	}
}
