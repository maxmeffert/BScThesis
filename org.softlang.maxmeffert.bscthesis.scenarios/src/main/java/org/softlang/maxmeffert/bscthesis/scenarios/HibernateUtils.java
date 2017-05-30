package org.softlang.maxmeffert.bscthesis.scenarios;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.softlang.maxmeffert.bscthesis.scenarios.model.Company;

public class HibernateUtils {
	
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new Configuration().configure(new File("./hibernate.cfg.xml")).buildSessionFactory();
		} catch (Throwable e) {
			System.err.println(e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private static <T> Optional<T> first(List<T> list) {
		return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
	}
	
	private static <T> Optional<T> last(List<T> list) {
		return list.isEmpty() ? Optional.empty() : Optional.of(list.get(list.size()-1));
	}
	
	public static void insert(Session session, Company company) {
		session.beginTransaction();
		session.save(company);
		session.getTransaction().commit();
	}
	
	public static <T> List<T> selectAll(Session session, Class<T> type) {
		CriteriaQuery<T> query = session.getCriteriaBuilder().createQuery(type);
		return session.createQuery(query.select(query.from(type))).getResultList();
	}
	
	public static <T> Optional<T> selectFirst(Session session, Class<T> type) {
		return first(selectAll(session, type));
	}
	
	public static <T> Optional<T> selectLast(Session session, Class<T> type) {
		return last(selectAll(session, type));
	}
	
	public static List<Company> selectAllCompanies(Session session) {
		return selectAll(session, Company.class);
	}
	
	public static Optional<Company> selectFirstCompany(Session session) {
		return selectFirst(session, Company.class);
	}
	
	public static Optional<Company> selectLastCompany(Session session) {
		return selectLast(session, Company.class);
	}
	
}
