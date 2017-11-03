package org.softlang.megal.plugins.impl.java;

import org.softlang.megal.plugins.api.antlr.ANTLRParserFactory;
import org.softlang.megal.plugins.api.antlr.ParseTreeFragmentizerPlugin;
import org.softlang.megal.plugins.impl.java.antlr.JavaLexer;
import org.softlang.megal.plugins.impl.java.antlr.JavaParser;
import org.softlang.megal.plugins.impl.java.antlr.JavaParserFactory;

public class JavaFragmentizer2 extends ParseTreeFragmentizerPlugin<JavaParser, JavaLexer> {

	@Override
	public ANTLRParserFactory<JavaParser, JavaLexer> getParserFactory() {
		
		return new JavaParserFactory();
	}

}
