package com.sanjoyghosh.stockslib;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManager	entityManager;
	
	
	public static EntityManager getEntityManager() {
		if (entityManager != null) {
			return entityManager;
		}
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.sanjoyghosh.stockslib");
		entityManager = emFactory.createEntityManager();
		return entityManager;
	}
}
