package com.sanjoyghosh.earnings;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sanjoyghosh.earnings.model.Stock;

public class YahooEarningsPage {
	
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

	private EntityManager em;
	
    public void processEarningsFor(Calendar date) throws IOException {
    	em = HibernateUtil.getEntityManager();
    	em.getTransaction().begin();
    	
    	String dateString = dateFormat.format(date.getTime());
    	String yepUrl = "http://biz.yahoo.com/research/earncal/" + dateString + ".html";
    	
		Document doc = Jsoup.connect(yepUrl).get();
	    Elements trElements = doc.select("table[cellpadding=2").select("tr");
	    for (int i = 0; i < trElements.size(); i++) {
	    	Element trElement = trElements.get(i);
	    	
	    	String name = null;
	    	Elements tdElements = trElement.select("td");
	    	if (!tdElements.isEmpty()) {
	    		name = tdElements.first().text();
	    	}
	    	
	    	Elements aElements = trElement.select("a[href^=http://finance.yahoo.com/q?s]");
	    	if (!aElements.isEmpty()) {
	    		String symbol = aElements.text();
	    		Stock stock = findStockBySymbol(symbol);
	    		if (stock == null) {
	    			addStock(symbol, name);
	    		}
	    	}
	    }
	    em.getTransaction().commit();
    }
    
    
    private void addStock(String symbol, String name) {
    	Stock stock = new Stock(symbol, name);
    	em.persist(stock);
    	System.out.println("PERSISTED: " + stock);
    }
    
     
    public Stock findStockBySymbol(String symbol) {
    	try {
	    	Stock stock = em.createNamedQuery("findStockBySymbol", Stock.class).setParameter("symbol", symbol).getSingleResult();
	    	return stock;
    	}
    	catch (NoResultException e) {
    	}
    	return null;
    }
}
