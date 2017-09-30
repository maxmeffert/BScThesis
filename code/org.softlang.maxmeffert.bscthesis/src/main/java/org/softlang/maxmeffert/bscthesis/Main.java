package org.softlang.maxmeffert.bscthesis;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.softlang.maxmeffert.bscthesis.analyzer.IAnalyzer;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingConfiguration;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.ioc.IoCGuiceModule;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.text.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITree;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITreeWalker;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITreeWalkerListener;

public class Main {

	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new IoCGuiceModule());

		IAnalyzer analyzer = injector.getInstance(IAnalyzer.class);
		analyzer.findCorrespondences("class A {class A {}}","");
	}

}
