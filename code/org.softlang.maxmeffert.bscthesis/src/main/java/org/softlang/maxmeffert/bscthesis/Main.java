package org.softlang.maxmeffert.bscthesis;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingConfiguration;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.ioc.IoCGuiceModule;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.text.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;
import org.softlang.maxmeffert.bscthesis.trees.ITreeWalker;
import org.softlang.maxmeffert.bscthesis.trees.ITreeWalkerFactory;
import org.softlang.maxmeffert.bscthesis.trees.ITreeWalkerListener;

public class Main {

	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new IoCGuiceModule());

        IAntlrParsingConfigurations antlrParsingConfigurations = injector.getInstance(IAntlrParsingConfigurations.class);

		IAntlrParsingConfiguration antlrParsingConfiguration = antlrParsingConfigurations.newJava8Configuration();

		IAntlrParsingResult antlrParsingResult = antlrParsingConfiguration.parse("class A {class A {}}");

		ISimpleParseTreeFactory parseTreeFactory = injector.getInstance(ISimpleParseTreeFactory.class);

		ITree<ITextSource> tree = parseTreeFactory.newSimpleParseTree(antlrParsingResult);

		ITreeWalker<ITextSource> treeWalker = injector.getInstance(ITreeWalkerFactory.class).newTreeWalker();

		treeWalker.walk(tree, new ITreeWalkerListener<ITextSource>() {
			@Override
			public void enter(ITree<ITextSource> tree) {
				System.out.println(tree);
			}

			@Override
			public void exit(ITree<ITextSource> tree) {

			}
		});

	}

}
