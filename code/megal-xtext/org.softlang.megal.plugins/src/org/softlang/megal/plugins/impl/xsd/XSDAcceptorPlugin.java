package org.softlang.megal.plugins.impl.xsd;

import java.io.IOException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.acceptors.AcceptorPlugin;
import org.xml.sax.SAXException;

import com.google.common.base.Optional;
import com.google.common.base.Throwables;

public class XSDAcceptorPlugin extends AcceptorPlugin {
	
	private void parseArtifact(Artifact artifact) throws SAXException, IOException {
		// 1. Lookup a factory for the W3C XML Schema language
		SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		factory.newSchema(new StreamSource(artifact.getBytes().openStream()));
	}
	
	@Override
	public Optional<String> accept(Artifact artifact) {
		try {
			parseArtifact(artifact);
			return Optional.absent();
		} catch (IOException | SAXException e) {
			return Optional.of(Throwables.getStackTraceAsString(e));
		}
	}
}
