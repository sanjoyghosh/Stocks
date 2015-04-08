package com.sanjoyghosh.stockslib.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarUtils {

	public static int toInt(Calendar date) {
		if (date == null) {
			return -1;
		}
		
		int dateInt = date.get(Calendar.YEAR) * 10000;
		dateInt += date.get(Calendar.MONTH) * 100;
		dateInt += date.get(Calendar.DAY_OF_MONTH);
		return dateInt;
	}
	
	public static Calendar toCalendar(int dateInt) {
		GregorianCalendar calendar = new GregorianCalendar(dateInt / 10000, (dateInt % 10000) / 100, dateInt % 1000000);
		return calendar;
	}
}
