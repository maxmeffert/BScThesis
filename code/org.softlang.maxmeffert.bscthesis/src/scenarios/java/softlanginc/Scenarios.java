package softlanginc;

import softlanginc.model.Company;

import java.io.File;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.xml.bind.JAXBException;

public class Scenarios {
	
	private static final String xmlOutputPath = "./xml";
	private static final String sqlOutputPath = "./sql";
	private static final File xmlFile = new File(xmlOutputPath + "/companies.xml");
	private static final File xsdFile = new File(xmlOutputPath + "/companies.xsd");
	private static final File ddlFile = new File(sqlOutputPath + "/companies.ddl.sql");
	
	
	private static Company initSoftlangInc(EntityManager em) {
		return JPAUtils.insert(em, SoftlangInc.getCompany());
	}
	
	private static void generateDDL() {
		HibernateUtils.generateDDL(ddlFile);
	}
	
	private static void generateXSD() throws IOException, JAXBException {
		JAXBUtils.generateSchema(xsdFile);
	}
	
	private static void marshal(Company company) throws JAXBException {
		JAXBUtils.marshal(company, xmlFile);
	}
	
	public static void main(String[] args) throws JAXBException {
//		JPAUtils.openConnection();
//		EntityManager em = JPAUtils.getEntityManager();
//		try {
//			generateDDL();
//			generateXSD();
//			Company company = initSoftlangInc(em);
//			marshal(company);
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		finally {
//			JPAUtils.closeConnection();
//		}
		JAXBUtils.marshal(SoftlangInc.getCompany(), xmlFile);
	}

}
