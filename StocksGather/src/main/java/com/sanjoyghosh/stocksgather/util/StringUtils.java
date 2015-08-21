package com.sanjoyghosh.stocksgather.util;

public class StringUtils {
	
	public static Long parseLongWithBM(String longStr) {
		if (longStr == null) {
			return null;
		}
		
		longStr = longStr.trim();
		if (longStr.endsWith("B")) {
			longStr = longStr.substring(0, longStr.length() - 1);
			Long longVal = StringUtils.parseFloat(longStr).longValue();
			longVal = longVal * 1000000000;
			return longVal;
		}
		if (longStr.endsWith("M")) {
			longStr = longStr.substring(0, longStr.length() - 1);
			Long longVal = StringUtils.parseFloat(longStr).longValue();
			longVal = longVal * 1000000;
			return longVal;
		}
		
		Float floatVal = StringUtils.parseFloat(longStr);
		return floatVal == null ? null : floatVal.longValue();
	}

	public static Integer parseInteger(String intStr) {
		if (intStr == null) {
			return null;
		}
		
		intStr = intStr.replaceAll(",", "");
		try {
			Integer integer = Integer.parseInt(intStr);
			return integer;
		}
		catch (NumberFormatException e) {
			return null;
		}
	}

	public static Float parseFloat(String floatStr) {
		if (floatStr == null) {
			return null;
		}
		floatStr = floatStr.trim();
		if (floatStr.equals("N/A")) {
			return null;
		}
		
		floatStr = floatStr.replaceAll(",", "");
		try {
			Float flt = Float.parseFloat(floatStr);
			return flt;
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Float[] parseFloatRange(String floatRangeStr) {
		if (floatRangeStr == null) {
			return null;
		}
		
		String[] floatStrings = floatRangeStr.split("-");
		if (floatStrings == null || floatStrings.length != 2) {
			return null;
		}
		
		Float[] floats = new Float [2];
		floats[0] = StringUtils.parseFloat(floatStrings[0]);
		floats[1] = StringUtils.parseFloat(floatStrings[1]);
		return floats;
	}
}
