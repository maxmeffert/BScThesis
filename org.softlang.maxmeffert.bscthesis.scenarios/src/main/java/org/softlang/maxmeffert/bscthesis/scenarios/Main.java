package org.softlang.maxmeffert.bscthesis.scenarios;

import org.hibernate.Session;
import org.softlang.maxmeffert.bscthesis.scenarios.model.Employee;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		
		Employee e = new Employee();
		e.setName("Alan Turing");
		e.setAge(42);
		e.setSalary(50000);
		
		session.save(e);
		
		
		session.getTransaction().commit();
		HibernateUtils.getSessionFactory().close();

	}

}
