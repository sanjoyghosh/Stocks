package com.sanjoyghosh.stockslib;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.sanjoyghosh.stockslib.db.model.AnalystOpinionYahoo;
import com.sanjoyghosh.stockslib.db.model.EarningsDate;
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


	public static EarningsDate addNewEarningsDate(EarningsDate earningsDate) {
		entityManager.persist(earningsDate);
		return earningsDate;
	}


	public static AnalystOpinionYahoo addNewAnalystOpinionYahoo(AnalystOpinionYahoo aoy) {
		entityManager.persist(aoy);
		return aoy;
	}


	public static AnalystOpinionYahoo findAnalystOpinionYahooByStockIdLatest(int stockId) {
		List<AnalystOpinionYahoo> aoyList = entityManager.createNamedQuery("findAnalystOpinionYahooByStockId", AnalystOpinionYahoo.class).setParameter("stockId", stockId).getResultList();
		if (aoyList == null || aoyList.size() == 0) {
			return null;
		}
		return aoyList.get(0);
	}
}
