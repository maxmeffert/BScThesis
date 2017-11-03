package plugins.jaxb;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.softlang.megal.mi2.api.Artifact;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.google.common.base.Optional;
import com.google.common.base.Throwables;

import plugins.root.elementof.Acceptor;

public class AcceptXML extends Acceptor {
	@Override
	public Optional<String> accept(Artifact artifact) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		try (InputStream stream = artifact.getBytes().openStream()) {
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();

			reader.parse(new InputSource(stream));
			return Optional.absent();
		} catch (SAXException e) {
			return Optional.of("File not element of language:\r\n" + e.getMessage());
		} catch (IOException | ParserConfigurationException e) {
			return Optional.of("File not element of language:\r\n" + Throwables.getStackTraceAsString(e));
		}
	}
}
