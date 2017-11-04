package org.softlang.maxmeffert.bscthesis.ccrecovery.companies;

import org.softlang.maxmeffert.bscthesis.ccrecovery.companies.model.Company;
import org.softlang.maxmeffert.bscthesis.ccrecovery.companies.model.Department;
import org.softlang.maxmeffert.bscthesis.ccrecovery.companies.model.Employee;

import javax.xml.bind.*;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


public class JAXBUtils {

	public static JAXBContext newContext() throws JAXBException {
		return JAXBContext.newInstance(Company.class, Department.class, Employee.class);
	}
	
	public static Marshaller newMarshaller() throws JAXBException {
		Marshaller marshaller =  newContext().createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		return marshaller;
	}
	
	public static void marshal(Object object, File file) throws JAXBException {
		newMarshaller().marshal(object, file);
	}
	
	public static Unmarshaller newUnmarshaller() throws JAXBException {
		return newContext().createUnmarshaller();
	}
	
	public static Object unmarshal(File file) throws JAXBException {
		return newUnmarshaller().unmarshal(file);
	}
	
	public static Company unmarshalCompany(File file) throws JAXBException {
		return (Company) unmarshal(file);
	}
	
	public static void generateSchema(File file) throws IOException, JAXBException {
		newContext().generateSchema(new SchemaOutputResolver() {

			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
		        StreamResult result = new StreamResult(file);
		        result.setSystemId(file.toURI().toURL().toString());
		        return result;
			}
			
		});
	}
	
}
