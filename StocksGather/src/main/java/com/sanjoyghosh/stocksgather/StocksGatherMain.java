package com.sanjoyghosh.stocksgather;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StocksGatherMain {
	
	private static final Logger logger = LogManager.getLogger(StocksGatherMain.class);

	public static void main(String[] args) {
		YahooEarningsPage yep = new YahooEarningsPage();
		Calendar calendar = new GregorianCalendar();
		for (int i = 0; i < 7; i++) {
			try {
				yep.processEarningsFor(calendar);
			} 
			catch (Exception e) {
				logger.fatal("Exception in main", e);
				System.exit(-1);
			}
			calendar.add(Calendar.DATE, 1);
		}
		System.out.println("All Kosher, Good Night.");
		System.exit(0);
	}
}
