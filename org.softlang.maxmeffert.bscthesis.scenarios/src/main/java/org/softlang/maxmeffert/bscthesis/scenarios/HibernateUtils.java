package org.softlang.maxmeffert.bscthesis.scenarios;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
	
}
