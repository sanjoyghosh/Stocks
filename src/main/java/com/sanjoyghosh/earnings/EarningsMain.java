package com.sanjoyghosh.earnings;

import java.io.IOException;
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
			catch (IOException e) {
				e.printStackTrace();
			}
			calendar.add(Calendar.DATE, 1);
		}
		System.exit(0);
	}
}
