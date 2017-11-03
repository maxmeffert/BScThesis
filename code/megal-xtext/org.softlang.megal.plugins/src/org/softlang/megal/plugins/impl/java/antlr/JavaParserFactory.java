package org.softlang.megal.plugins.impl.java.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.megal.plugins.api.antlr.ANTLRParserFactory;

/**
 * ANTLR parser factory for common java
 * 
 * @author maxmeffert
 *
 */
public class JavaParserFactory extends ANTLRParserFactory<JavaParser, JavaLexer>{

	@Override
	public JavaLexer getLexer(CharStream chars) {
		return new JavaLexer(chars);
	}

	@Override
	public JavaParser getParser(TokenStream tokens) {
		return new JavaParser(tokens);
	}

	@Override
	public ParseTree getParseTree(JavaParser parser) {
		return parser.compilationUnit();
	}

}
