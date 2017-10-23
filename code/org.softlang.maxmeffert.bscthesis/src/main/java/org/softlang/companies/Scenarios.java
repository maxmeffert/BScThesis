package org.softlang.companies;

import org.softlang.companies.model.Company;

import java.io.File;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.xml.bind.JAXBException;

public class Scenarios {
	
	private static final String xmlOutputPath = "./artifacts";
	private static final String sqlOutputPath = "./artifacts";
	private static final File xmlFile = new File(xmlOutputPath + "/companies.xml");
	private static final File xsdFile = new File(xmlOutputPath + "/companies.xsd");
	private static final File ddlFile = new File(sqlOutputPath + "/companies.ddl.sql");
	
	
	private static Company initSoftlangInc(EntityManager em) {
		return JPAUtils.insert(em, SoftlangInc.getCompany());
	}
	
	private static void generateDDL() throws IOException {
		JPAUtils.openConnection();
		EntityManager em = JPAUtils.getEntityManager();
		try {
			HibernateUtils.generateDDL(ddlFile);
		}
		finally {
			JPAUtils.closeConnection();
		}
	}
	
	private static void generateXSD() throws IOException, JAXBException {
		JAXBUtils.generateSchema(xsdFile);
	}

	private static void generateXML() throws IOException, JAXBException {
		JAXBUtils.marshal(SoftlangInc.getCompany(), xmlFile);
	}

	public static void main(String[] args) throws JAXBException, IOException {
//		generateDDL();
		generateXML();
		generateXSD();
	}

}
