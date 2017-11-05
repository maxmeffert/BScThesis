package org.softlang.megal.plugins.impl.xsd;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.AcceptorPlugin;
import org.xml.sax.SAXException;

import com.google.common.base.Optional;
import com.google.common.base.Throwables;

public class XSDAcceptorPlugin extends AcceptorPlugin {
	@Override
	public Optional<String> accept(Artifact artifact) {
		// 1. Lookup a factory for the W3C XML Schema language
		SchemaFactory factory = SchemaFactory
				.newInstance("http://www.w3.org/2001/XMLSchema");

		try (InputStream stream = artifact.getBytes().openStream()) {
			factory.newSchema(new StreamSource(stream));
			return Optional.absent();
		} catch (IOException | SAXException e) {
			return Optional.of(Throwables.getStackTraceAsString(e));
		}
	}
}
