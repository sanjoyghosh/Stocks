package com.sanjoyghosh.stockslib.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@NamedQuery(name="findEarningsDateByAll", query="SELECT ed FROM EarningsDate ed WHERE ed.stockId = :stockId AND ed.earningsDate = :earningsDate AND ed.earningsReleaseTimeEnum = :earningsReleaseTimeEnum")

@Entity
public class EarningsDate extends AbstractStockBasedObject implements Serializable {

	private static final long serialVersionUID = 4263519372478222266L;

	@Column
	private Integer earningsDate;
	
	@Column
	private Integer earningsReleaseTimeEnum;
	
	
	public EarningsDate() {}


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
