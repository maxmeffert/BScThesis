package org.softlang.maxmeffert.bscthesis.scenarios;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.softlang.maxmeffert.bscthesis.scenarios.model.*;


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
