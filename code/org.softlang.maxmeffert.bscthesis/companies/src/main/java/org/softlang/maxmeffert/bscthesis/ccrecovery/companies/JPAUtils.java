package org.softlang.maxmeffert.bscthesis.ccrecovery.companies;

import org.softlang.maxmeffert.bscthesis.ccrecovery.companies.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtils {
	private static final String persistenceUnitName = "org.softlang.maxmeffert.bscthesis.ccrecovery.companies";
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static void closeConnection() {
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}
	
	public static EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	public static Company insert(EntityManager em, Company company) {
		em.getTransaction().begin();
		em.persist(company);;
		em.flush();
		em.getTransaction().commit();
		return company;
	}
	
}
