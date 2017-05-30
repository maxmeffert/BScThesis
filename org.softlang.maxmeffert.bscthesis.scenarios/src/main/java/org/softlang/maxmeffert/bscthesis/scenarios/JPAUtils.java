package org.softlang.maxmeffert.bscthesis.scenarios;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.softlang.maxmeffert.bscthesis.scenarios.model.*;

public class JPAUtils {
	private static final String persistenceUnitName = "org.softlang.companies";
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
	
	private static <T> Optional<T> first(List<T> list) {
		return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
	}
	
	private static <T> Optional<T> last(List<T> list) {
		return list.isEmpty() ? Optional.empty() : Optional.of(list.get(list.size()-1));
	}
	
	public static Company insert(EntityManager em, Company company) {
//		em.getTransaction().begin();
		em.persist(company);
		System.out.println(company);
//		em.flush();
//		em.getTransaction().commit();
		return company;
	}
}
