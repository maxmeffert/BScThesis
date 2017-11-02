package org.softlang.megal.acme;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class Test {

	static final private String SCHEMA_LOCATION = "./input/org/softlang/megal/acme/acme.xsd";
	static final private String XML_LOCATION = "./input/org/softlang/megal/acme/acme.xml";
	
	static private Schema createSchema (JAXBContext context) throws SAXException, IOException {
		
		File file = new File(SCHEMA_LOCATION);
		
		context.generateSchema(new SchemaOutputResolver(){

			@Override
			public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException {
		        
		        StreamResult result = new StreamResult(file);
		        result.setSystemId(file.toURI().toURL().toString());
		        return result;
		        
		    }
			
		});
		
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = factory.newSchema(file);
		
		return schema;
		
	}
	
	static private Company createSampleCompany () {
		
		Company c = new Company();
		c.setName("ACME");
		
		for (int i=0; i<10; i++) {
			
			Department d = new Department();
			d.setName("D"+i);
			
			for (int j=0; j<10; j++) {
				
				Employee e = new Employee();
				e.setName("E" + j);
				e.setSalary( (j+1) * 1000 );
				
				d.addEmployee(e);
				
			}
			
			c.addDepartment(d);
			
		}
		
		return c;
		
	}
	
	static public void main(String[] args) {
		
		try {
			
			JAXBContext companyContext = JAXBContext.newInstance(Company.class);
			
			Schema schema = createSchema(companyContext);
			
			Marshaller m = companyContext.createMarshaller();
			m.setSchema(schema);
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, SCHEMA_LOCATION);
			
			Company c = createSampleCompany();
			
			m.marshal(c, System.out);
			m.marshal(c, new FileOutputStream(new File(XML_LOCATION)));
			
			
		} catch (JAXBException | IOException | SAXException e) {

			e.printStackTrace();

		}

	}

}
