package org.softlang.maxmeffert.bscthesis.scenarios;

import java.io.File;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBException;

import org.hibernate.Session;
import org.softlang.maxmeffert.bscthesis.scenarios.model.*;

public class Scenarios {
	
	private static final String xmlOutputPath = "./xml";
	private static final File xmlFile = new File(xmlOutputPath + "/companies.xml");
	private static final File xsdFile = new File(xmlOutputPath + "/companies.xsd");
	
	private static Company initSoftlangInc(Session session) {
		HibernateUtils.insert(session, SoftlangInc.getCompany());
		return HibernateUtils.selectLastCompany(session).get();
	}
	
	private static Company initSoftlangInc(EntityManager em) {
		return JPAUtils.insert(em, SoftlangInc.getCompany());
	}
	
	
	private static void generateSchema() throws IOException, JAXBException {
		JAXBUtils.generateSchema(xsdFile);
	}
	
	private static void marshal(Company company) throws JAXBException {
		JAXBUtils.marshal(company, xmlFile);
	}
	
	public static void main(String[] args) {
		JPAUtils.openConnection();
		EntityManager em = JPAUtils.getEntityManager();
//		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			generateSchema();
			Company company = initSoftlangInc(em);
			System.out.println(company);
			marshal(company);
			System.out.println(company);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			JPAUtils.closeConnection();
		}
	}

}
