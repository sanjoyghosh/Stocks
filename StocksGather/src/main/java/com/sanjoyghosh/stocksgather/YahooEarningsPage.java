package com.sanjoyghosh.stocksgather;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sanjoyghosh.stockslib.StocksLib;
import com.sanjoyghosh.stockslib.db.model.AnalystOpinionYahoo;
import com.sanjoyghosh.stockslib.db.model.EarningsDate;
import com.sanjoyghosh.stockslib.db.model.Stock;
import com.sanjoyghosh.stockslib.enums.EarningsReleaseTimeEnum;
import com.sanjoyghosh.stockslib.util.CalendarUtils;

public class YahooEarningsPage {
	
	private static final Logger logger = LogManager.getLogger(YahooEarningsPage.class);
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	
    public void processEarningsFor(Calendar date) throws IOException {    	
    	String dateString = dateFormat.format(date.getTime());
    	String yepUrl = "http://biz.yahoo.com/research/earncal/" + dateString + ".html";
    	
		Document doc = null;
		for (int i = 0; i < 12; i++) {
			try {
				doc = Jsoup.connect(yepUrl).get();
				break;
			}
			catch (HttpStatusException e) {
				logger.error("Cannot fetch url: " + yepUrl, e);
			}
		}
		StocksLib.transactionBegin();
		
	    Elements trElements = doc.select("table[cellpadding=2").select("tr");
	    for (int i = 0; i < trElements.size(); i++) {
	    	Element trElement = trElements.get(i);
	    	
	    	String name = null;
	    	Elements tdElements = trElement.select("td");
	    	if (!tdElements.isEmpty()) {
	    		name = tdElements.first().text();
	    	}
	    	
	    	Elements aElements = trElement.select("a[href^=http://finance.yahoo.com/q?s]");
	    	Elements smallElements = trElement.select("small");
	    	if (!aElements.isEmpty()) {
	    		String symbol = aElements.text();
	    		Stock stock = StocksLib.findStockBySymbol(symbol);
	    		if (stock == null) {
	    			stock = new Stock(symbol, name);
	    			StocksLib.addNewStock(stock);
	    		}
	    		
	    		int stockId = stock.getId();
	    		int earningsDate = CalendarUtils.toInt(date);
	    		int earningsReleaseTimeEnum = EarningsReleaseTimeEnum.toEarningsReleaseTimeEnum(smallElements.text()).ordinal();
	    		EarningsDate ed = StocksLib.findEarningsDateByAll(stockId, earningsDate, earningsReleaseTimeEnum);
	    		if (ed == null) {
	    			ed = new EarningsDate();
		    		ed.setStockId(stockId);
		    		ed.setEarningsDate(earningsDate);
		    		ed.setEarningsReleaseTimeEnum(earningsReleaseTimeEnum);
		    		StocksLib.addNewEarningsDate(ed);
	    		}
	    		
	    		AnalystOpinionYahoo aoy = fetchAnalystOpinionYahoo(symbol);
	    		if (aoy != null) {
	    			aoy.setStockId(stockId);
	    			aoy.setCreatedDate(earningsDate);
	    			AnalystOpinionYahoo aoyInDB = StocksLib.findAnalystOpinionYahooByStockIdLatest(stockId);
	    			if (aoyInDB == null || !aoy.isTheSameAs(aoyInDB)) {
		    			StocksLib.addNewAnalystOpinionYahoo(aoy);
	    			}
	    		}
	    	}
	    }
	    StocksLib.transactionCommit();
    }
    
    
	private AnalystOpinionYahoo fetchAnalystOpinionYahoo(String symbol) throws IOException {
		AnalystOpinionYahoo aoy = AnalystOpinionYahooFetcher.fetchAnalystOpinionYahoo(symbol);
		return aoy;
	}
}
