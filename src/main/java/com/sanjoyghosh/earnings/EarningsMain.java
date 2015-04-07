package com.sanjoyghosh.earnings;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EarningsMain {

	public static void main(String[] args) {
		YahooEarningsPage yep = new YahooEarningsPage();
		Calendar calendar = new GregorianCalendar();
		for (int i = 0; i < 14; i++) {
			try {
				yep.processEarningsFor(calendar);
			} 
			catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
			calendar.add(Calendar.DATE, 1);
		}
		System.exit(0);
	}
}
