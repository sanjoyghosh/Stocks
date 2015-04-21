package com.sanjoyghosh.stockslib.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractStockBasedObject extends AbstractDBObject implements Serializable {

	private static final long serialVersionUID = -5563402013043152304L;
	
	@Column
	private Integer stockId;

	
	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
}
