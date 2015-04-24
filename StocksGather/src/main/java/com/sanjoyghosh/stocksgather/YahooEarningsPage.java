package com.sanjoyghosh.stocksgather;

import java.io.IOException;
import java.util.Calendar;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sanjoyghosh.stocksgather.util.JsoupUtils;
import com.sanjoyghosh.stockslib.StocksLib;
import com.sanjoyghosh.stockslib.db.model.EarningsDate;
import com.sanjoyghosh.stockslib.db.model.Stock;
import com.sanjoyghosh.stockslib.enums.EarningsReleaseTimeEnum;
import com.sanjoyghosh.stockslib.util.CalendarUtils;

class YahooEarningsPage {
	
	static void processEarningsFor(Calendar date, int todayInt) throws IOException {   
		int earningsDateInt = CalendarUtils.toInt(date);
    	String yepUrl = "http://biz.yahoo.com/research/earncal/" + String.valueOf(earningsDateInt) + ".html";
    	
		Document doc = JsoupUtils.fetchDocument(yepUrl);		
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
	    			stock = new Stock();
	    			stock.setCreatedDate(todayInt);
	    			stock.setName(name);
	    			stock.setSymbol(symbol);
	    			StocksLib.addNewStock(stock);
	    		}
	    		
	    		int stockId = stock.getId();
	    		int earningsReleaseTimeEnum = EarningsReleaseTimeEnum.toEarningsReleaseTimeEnum(smallElements.text()).ordinal();
	    		EarningsDate ed = StocksLib.findEarningsDateByAll(stockId, earningsDateInt, earningsReleaseTimeEnum);
	    		if (ed == null) {
	    			ed = new EarningsDate();
	    			ed.setStockId(stockId);
	    			ed.setCreatedDate(todayInt);
		    		ed.setEarningsDate(earningsDateInt);
		    		ed.setEarningsReleaseTimeEnum(earningsReleaseTimeEnum);
		    		StocksLib.addEarningsDate(ed);
	    		}
	    	}
	    }
    }
}
