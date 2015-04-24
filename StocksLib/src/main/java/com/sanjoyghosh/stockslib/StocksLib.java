package com.sanjoyghosh.stockslib;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.sanjoyghosh.stockslib.db.model.AnalystOpinionYahoo;
import com.sanjoyghosh.stockslib.db.model.EarningsDate;
import com.sanjoyghosh.stockslib.db.model.QuoteYahoo;
import com.sanjoyghosh.stockslib.db.model.Stock;

public class StocksLib {
	
	// private static final Logger logger = LogManager.getLogger(StocksLib.class);
	private static final EntityManager entityManager = HibernateUtil.getEntityManager();
	
	
	public static void transactionBegin() {
		entityManager.getTransaction().begin();
	}
	
	
	public static void transactionCommit() {
		entityManager.getTransaction().commit();
	}
	
	
	public static List<Stock> findAllStocks() {
    	try {
	    	List<Stock> stocks = entityManager.createNamedQuery("findAllStocks", Stock.class).getResultList();
	    	return stocks;
    	}
    	catch (NoResultException e) {}
    	return null;
	}

	
	public static Stock findStockBySymbol(String symbol) {
    	try {
	    	Stock stock = entityManager.createNamedQuery("findStockBySymbol", Stock.class).setParameter("symbol", symbol).getSingleResult();
	    	return stock;
    	}
    	catch (NoResultException e) {}
    	return null;
	}
	
	
	public static Stock addNewStock(Stock stock) {
		entityManager.persist(stock);
		return stock;
	}
	
	
	public static EarningsDate findEarningsDateByAll(int stockId, int earningsDate, int earningsReleaseTimeEnum) {
		try {
			EarningsDate ed = entityManager.createNamedQuery("findEarningsDateByAll", EarningsDate.class)
				.setParameter("stockId", stockId)
				.setParameter("earningsDate", earningsDate)
				.setParameter("earningsReleaseTimeEnum", earningsReleaseTimeEnum)
				.getSingleResult();
			return ed;
		}
		catch (NoResultException e) {}
		return null;
	}


	public static EarningsDate addEarningsDate(EarningsDate earningsDate) {
		entityManager.persist(earningsDate);
		return earningsDate;
	}


	public static AnalystOpinionYahoo addAnalystOpinionYahoo(AnalystOpinionYahoo aoy) {
		entityManager.persist(aoy);
		return aoy;
	}


	public static void updateAnalystOpinionYahoo(AnalystOpinionYahoo aoy) {
		entityManager.merge(aoy);
	}


	public static QuoteYahoo addQuoteYahoo(QuoteYahoo qy) {
		entityManager.persist(qy);
		return qy;
	}


	public static void updateQuoteYahoo(QuoteYahoo qy) {
		entityManager.merge(qy);
	}

	
	public static AnalystOpinionYahoo findAnalystOpinionYahooByStockIdCreatedDate(int stockId, int createdDateInt) {
		try {
			AnalystOpinionYahoo aoy = entityManager.createNamedQuery("findAnalystOpinionYahooByStockIdCreatedDate", AnalystOpinionYahoo.class)
				.setParameter("stockId", stockId)
				.setParameter("createdDate", createdDateInt)
				.getSingleResult();
			return aoy;
		}
		catch (NoResultException e) {}
		return null;
	}


	public static QuoteYahoo findQuoteYahooByStockIdCreatedDate(int stockId, int createdDateInt) {
		try {
			QuoteYahoo qy = entityManager.createNamedQuery("findQuoteYahooByStockIdCreatedDate", QuoteYahoo.class)
				.setParameter("stockId", stockId)
				.setParameter("createdDate", createdDateInt)
				.getSingleResult();
			return qy;
		}
		catch (NoResultException e) {}
		return null;
	}
}
