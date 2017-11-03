package org.softlang.megal.plugins.impl.xml.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.megal.plugins.api.antlr.ANTLRParserFactory;

public class XMLParserFactory extends ANTLRParserFactory<XMLParser, XMLLexer> {

	@Override
	public XMLLexer getLexer(CharStream chars) {
		return new XMLLexer(chars);
	}

	@Override
	public XMLParser getParser(TokenStream tokens) {
		return new XMLParser(tokens);
	}

	@Override
	public ParseTree getParseTree(XMLParser parser) {
		return parser.document();
	}

}
