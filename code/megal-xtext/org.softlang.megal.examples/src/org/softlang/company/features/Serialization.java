package org.softlang.company.features;

import org.softlang.company.xjc.Company;

import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.softlang.company.xjc.Employee;
public class Serialization {

	private static JAXBContext jaxbContext;

	public static void initializeJaxbContext() throws JAXBException {
		if (jaxbContext == null)
			jaxbContext = JAXBContext.newInstance("org.softlang.company.xjc");
	}

	public static Company deserializeCompany(File file) throws JAXBException,
			IOException {
		return deserializeCompany(Files.asByteSource(file));
	}

	public static Company deserializeCompany(ByteSource source)
			throws JAXBException, IOException {
		initializeJaxbContext();
		Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
		try (InputStream stream = source.openBufferedStream()) {
			return (Company) unMarshaller.unmarshal(stream);
		}
	}

	public static void serializeCompany(File file, Company c)
			throws JAXBException, XMLStreamException, IOException {
		serializeCompany(Files.asByteSink(file), c);
	}

	public static void serializeCompany(ByteSink target, Company c)
			throws JAXBException, XMLStreamException, IOException {
		initializeJaxbContext();

		try (OutputStream stream = target.openStream()) {
			Marshaller marshaller = jaxbContext.createMarshaller();
			XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
			XMLStreamWriter writer = outputFactory
					.createXMLStreamWriter(stream);
			marshaller.marshal(c, writer);
		}
	}

}