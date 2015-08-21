package com.sanjoyghosh.stocksgather;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sanjoyghosh.stocksgather.net.AnalystOpinionYahooFetcher;
import com.sanjoyghosh.stocksgather.net.QuoteYahooFetcher;
import com.sanjoyghosh.stockslib.StocksLib;
import com.sanjoyghosh.stockslib.db.model.AnalystOpinionYahoo;
import com.sanjoyghosh.stockslib.db.model.QuoteYahoo;
import com.sanjoyghosh.stockslib.db.model.Stock;
import com.sanjoyghosh.stockslib.util.CalendarUtils;

public class StocksGatherMain {
	
	private static final Logger logger = LogManager.getLogger(StocksGatherMain.class);

	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
    	int todayInt = CalendarUtils.toInt(calendar);
		StocksLib.transactionBegin();

		for (int i = 0; i < 7; i++) {
			try {
				YahooEarningsPage.processEarningsFor(calendar, todayInt);
			} 
			catch (Exception e) {
				logger.fatal("Exception in reading Yahoo Earnings Calendar", e);
				System.exit(-1);
			}
			calendar.add(Calendar.DATE, 1);
		}
		
		List<Stock> allStocks = StocksLib.findAllStocks();
		for (Stock stock : allStocks) {
			int stockId = stock.getId();
			String symbol = stock.getSymbol();
			
			try {
	    		AnalystOpinionYahoo aoy = AnalystOpinionYahooFetcher.fetchAnalystOpinionYahoo(symbol);
	    		if (aoy != null) {
	    			aoy.setStockId(stockId);
	    			aoy.setCreatedDate(todayInt);
	    			AnalystOpinionYahoo aoyInDB = StocksLib.findAnalystOpinionYahooByStockIdCreatedDate(stockId, todayInt);
	    			if (aoyInDB == null) {
		    			StocksLib.addAnalystOpinionYahoo(aoy);
	    			}
	    			else {
	    				aoy.setId(aoyInDB.getId());
	    				StocksLib.updateAnalystOpinionYahoo(aoy);
	    			}
	    		}
	    		
	    		QuoteYahoo qy = QuoteYahooFetcher.fetchQuoteYahoo(symbol);
	    		if (qy != null) {
    				qy.setStockId(stockId);
    				qy.setCreatedDate(todayInt);
	    			QuoteYahoo qyInDB = StocksLib.findQuoteYahooByStockIdCreatedDate(stockId, todayInt);
	    			if (qyInDB == null) {
	    				StocksLib.addQuoteYahoo(qy);
	    			}
	    			else {
	    				qy.setId(qyInDB.getId());
	    				StocksLib.updateQuoteYahoo(qy);
	    			}
	    		}
			}
			catch (Exception e) {
				logger.fatal("Exception in reading Yahoo Analyst Opinions and Quotes", e);
				System.exit(-1);
			}
		}
		
	    StocksLib.transactionCommit();
	    
	    FactSetEarningsEmail.processFactSetEarningsEmail();
		System.out.println("All Kosher, Good Night.");
		System.exit(0);
	}
}
