package com.sanjoyghosh.earnings.model;

import java.io.Serializable;
import java.util.Date;

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
	private Date earningsDate;
	
	@Column
	private String earningsReleaseTimeAbbrev;
	
	
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

	public Date getEarningsDate() {
		return earningsDate;
	}

	public void setEarningsDate(Date earningsDate) {
		this.earningsDate = earningsDate;
	}

	public String getEarningsReleaseTimeAbbrev() {
		return earningsReleaseTimeAbbrev;
	}

	public void setEarningsReleaseTimeAbbrev(String earningsReleaseTimeAbbrev) {
		this.earningsReleaseTimeAbbrev = earningsReleaseTimeAbbrev;
	}
}
