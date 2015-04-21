package com.sanjoyghosh.stockslib.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractDBObject implements Serializable {

	private static final long serialVersionUID = 4531867895940507147L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Integer createdDate;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Integer createdDate) {
		this.createdDate = createdDate;
	}	
}
