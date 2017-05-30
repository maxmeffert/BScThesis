package org.softlang.maxmeffert.bscthesis.scenarios;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.softlang.maxmeffert.bscthesis.scenarios.model.*;

public class Main {

	
	private static <T> Optional<T> first(List<T> list) {
		return list.size() > 0 ? Optional.of(list.get(0)) : Optional.empty();
	}
	
	private static void insert(Session session, Company company) {
		session.beginTransaction();
		session.save(company);
		session.getTransaction().commit();
	}
	
	private static <T> List<T> selectAll(Session session, Class<T> type) {
		CriteriaQuery<T> query = session.getCriteriaBuilder().createQuery(type);
		return session.createQuery(query.select(query.from(type))).getResultList();
	}
	
	private static <T> Optional<T> selectFirst(Session session, Class<T> type) {
		return first(selectAll(session, type));
	}
	
	private static List<Company> selectAllCompanies(Session session) {
		return selectAll(session, Company.class);
	}
	
	private static Optional<Company> selectFirstCompany(Session session) {
		return selectFirst(session, Company.class);
	}
	
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
//			insert(SoftlangInc.getCompany());
			
			Optional<Company> first = selectFirstCompany(session);
			
			if (first.isPresent()) {
				System.out.println(first.get().getName());
			}
		}
		finally {
			HibernateUtils.getSessionFactory().close();

		}
	}

}
