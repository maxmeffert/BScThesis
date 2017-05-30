package org.softlang.maxmeffert.bscthesis.scenarios;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.xml.bind.JAXBException;

import org.hibernate.Session;
import org.softlang.maxmeffert.bscthesis.scenarios.model.*;

public class Scenarios {
	
	private static final String xmlOutputPath = "./xml";
	private static final File xmlFile = new File(xmlOutputPath + "/companies.xml");
	private static final File xsdFile = new File(xmlOutputPath + "/companies.xsd");
	
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			JAXBUtils.generateSchema(xsdFile);
			HibernateUtils.insert(session, SoftlangInc.getCompany());
			Optional<Company> first = HibernateUtils.selectLastCompany(session);
			if (first.isPresent()) {
				Company company = first.get();
				JAXBUtils.newMarshaller().marshal(company, xmlFile);
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			HibernateUtils.getSessionFactory().close();

		}
	}

}
