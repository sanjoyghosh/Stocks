package com.sanjoyghosh.stockslib.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum EarningsReleaseTimeEnum {

	None("N"),
	Before_Market_Open("BMO"),
	Time_Not_Supplied("TNS"),
	After_Market_Close("AMC"),
	Some_Hour("SH");
	
	private static final Logger logger = LogManager.getLogger(EarningsReleaseTimeEnum.class);
	
	private String abbreviation;
	
	private EarningsReleaseTimeEnum(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
	
	public static EarningsReleaseTimeEnum toEarningsReleaseTimeEnum(String releaseTime) {
		if (releaseTime.equals("Before Market Open")) {
			return Before_Market_Open;
		}
		if (releaseTime.equals("Time Not Supplied")) {
			return Time_Not_Supplied;
		}
		if (releaseTime.equals("After Market Close")) {
			return After_Market_Close;
		}
		logger.error("Earnings Release Time: " + releaseTime);
		return Some_Hour;
	}
}
