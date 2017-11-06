package org.softlang.megal.plugins.impl.xml;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.acceptors.AcceptorPlugin;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.google.common.base.Optional;
import com.google.common.base.Throwables;

public class XMLAcceptorPlugin extends AcceptorPlugin {
	
	private void parseArtifact(Artifact artifact) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();
		reader.parse(new InputSource(artifact.getBytes().openStream()));
	}
	
	@Override
	public Optional<String> accept(Artifact artifact) {
		try  {
			parseArtifact(artifact);
			return Optional.absent();
		} catch (SAXException  e) {
			return Optional.of("File not element of language:\r\n"+e.getMessage());
		} catch (IOException  | ParserConfigurationException e) {
			return Optional.of("File not element of language:\r\n"+Throwables.getStackTraceAsString(e));
		}
	}
}
