package com.sanjoyghosh.stocksgather.net;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sanjoyghosh.stocksgather.util.JsoupUtils;
import com.sanjoyghosh.stockslib.db.model.AnalystOpinionYahoo;

public class AnalystOpinionYahooFetcher {

	private static final Logger logger = LogManager.getLogger(AnalystOpinionYahooFetcher.class);
	
	
	public static AnalystOpinionYahoo fetchAnalystOpinionYahoo(String symbol) throws IOException {
		String aoyUrl = "http://finance.yahoo.com/q/ao?s=" + symbol + "+Analyst+Opinion";
		Document doc = JsoupUtils.fetchDocument(aoyUrl);
		Elements elements = doc.select("td.yfnc_tabledata1");

		if (elements.size() > 0) {
			AnalystOpinionYahoo aoy = new AnalystOpinionYahoo();
			
			for (int i = 0; i < 8; i++) {
				Element element = elements.get(i);
				String text = element.text().trim();
				if (text.equals("N/A")) {
					return null;
				}
				text = text.replaceAll(",", "");
				try {
					switch(i) {
						case 0: aoy.setMeanRecommendationThisWeek(Float.parseFloat(text)); break;
						case 1: aoy.setMeanRecommendationLastWeek(Float.parseFloat(text)); break;
						case 2: aoy.setChangeMeanRecommendation(Float.parseFloat(text)); break;
						case 3: aoy.setMeanTarget(Float.parseFloat(text)); break;
						case 4: aoy.setMedianTarget(Float.parseFloat(text)); break;
						case 5: aoy.setHighTarget(Float.parseFloat(text)); break;
						case 6: aoy.setLowTarget(Float.parseFloat(text)); break;
						case 7: aoy.setNumberOfBrokers(Integer.parseInt(text)); break;
					}
				}
				catch (NumberFormatException e) {
					logger.error(i + "  " + text, e);
					return null;
				}
			}
	
			for (int i = elements.size() - 20; i < elements.size(); i++) {
				Element element = elements.get(i);
				String text = element.text().trim();
				Integer intValue = Integer.parseInt(text);
				int j = i - (elements.size() - 20);
				
				try {
					switch(j) {
						case 0: aoy.setStrongBuyCurrentMonth(intValue); break;
						case 1: aoy.setStrongBuyLastMonth(intValue); break;
						case 2: aoy.setStrongBuyTwoMonthsAgo(intValue); break;
						case 3: aoy.setStrongBuyThreeMonthsAgo(intValue); break;
						case 4: aoy.setBuyCurrentMonth(intValue); break;
						case 5: aoy.setBuyLastMonth(intValue); break;
						case 6: aoy.setBuyTwoMonthsAgo(intValue); break;
						case 7: aoy.setBuyThreeMonthsAgo(intValue); break;
						case 8: aoy.setHoldCurrentMonth(intValue); break;
						case 9: aoy.setHoldLastMonth(intValue); break;
						case 10: aoy.setHoldTwoMonthsAgo(intValue); break;
						case 11: aoy.setHoldThreeMonthsAgo(intValue); break;
						case 12: aoy.setUnderperformCurrentMonth(intValue); break;
						case 13: aoy.setUnderperformLastMonth(intValue); break;
						case 14: aoy.setUnderperformTwoMonthsAgo(intValue); break;
						case 15: aoy.setUnderperformThreeMonthsAgo(intValue); break;
						case 16: aoy.setSellCurrentMonth(intValue); break;
						case 17: aoy.setSellLastMonth(intValue); break;
						case 18: aoy.setSellTwoMonthsAgo(intValue); break;
						case 19: aoy.setSellThreeMonthsAgo(intValue); break;
					}
				}
				catch (NumberFormatException e) {
					logger.error(i + "  " + text, e);
					return null;
				}
			}
			return aoy;
		}
		return null;
	}
}
