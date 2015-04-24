package com.sanjoyghosh.stocksgather.net;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sanjoyghosh.stocksgather.util.JsoupUtils;
import com.sanjoyghosh.stocksgather.util.StringUtils;
import com.sanjoyghosh.stockslib.db.model.QuoteYahoo;

public class QuoteYahooFetcher {

	public static QuoteYahoo fetchQuoteYahoo(String symbol) throws IOException {
		String aoyUrl = "http://finance.yahoo.com/q?s=" + symbol;
		Document doc = JsoupUtils.fetchDocument(aoyUrl);
		
		Elements elements = doc.select("span.time_rtq_ticker");
		float price = StringUtils.parseFloat(elements.text());
		System.out.println(symbol + ": " + price);
		
		elements = doc.select("td.yfnc_tabledata1");
		Float previousClose = StringUtils.parseFloat(elements.get(0).text());
		Float open = StringUtils.parseFloat(elements.get(1).text());
		Float oneYearTarget = StringUtils.parseFloat(elements.get(4).text());
		
		String daysRangeStr = elements.get(7).text();
		Float[] dayRangeFloats = StringUtils.parseFloatRange(daysRangeStr);
		
		String fiftyTwoWeekRangeStr = elements.get(8).text();
		Float[] fiftyTwoWeekRangeFloats = StringUtils.parseFloatRange(fiftyTwoWeekRangeStr);
		
		Integer volume = StringUtils.parseInteger(elements.get(9).text());
		Integer threeMonthAverageVolume = StringUtils.parseInteger(elements.get(10).text());
		
		String marketCapStr = elements.get(11).text();		
		Long marketCap = StringUtils.parseLongWithBM(marketCapStr);
		
		QuoteYahoo qy = new QuoteYahoo();
		qy.setPrice(price);
		qy.setPreviousClose(previousClose);
		qy.setOpen(open);
		qy.setOneYearTarget(oneYearTarget);
		if (dayRangeFloats != null) {
			qy.setDayRangeLow(dayRangeFloats[0]);
			qy.setDayRangeHigh(dayRangeFloats[1]);
		}
		if (fiftyTwoWeekRangeFloats != null) {
			qy.setFiftyTwoWeekRangeLow(fiftyTwoWeekRangeFloats[0]);
			qy.setFiftyTwoWeekRangeHigh(fiftyTwoWeekRangeFloats[1]);
		}
		qy.setVolume(volume);
		qy.setThreeMonthAverageVolume(threeMonthAverageVolume);
		qy.setMarketCap(marketCap);
		System.out.println(qy);
		
		return qy;
	}
}
