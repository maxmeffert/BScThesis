package org.softlang.megal.plugins.impl.xml;

import org.softlang.megal.plugins.api.antlr.ANTLRAcceptorPlugin;
import org.softlang.megal.plugins.api.antlr.ANTLRParserFactory;
import org.softlang.megal.plugins.impl.xml.antlr.XMLLexer;
import org.softlang.megal.plugins.impl.xml.antlr.XMLParser;
import org.softlang.megal.plugins.impl.xml.antlr.XMLParserFactory;

public class XMLAcceptor extends ANTLRAcceptorPlugin<XMLParser, XMLLexer> {
	
	@Override
	public ANTLRParserFactory<XMLParser, XMLLexer> getParserFactory() {
		return new XMLParserFactory();
	}
	
}
