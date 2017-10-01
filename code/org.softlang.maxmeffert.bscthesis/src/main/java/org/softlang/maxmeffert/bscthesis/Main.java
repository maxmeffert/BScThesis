package org.softlang.maxmeffert.bscthesis;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.softlang.maxmeffert.bscthesis.graphs.*;
import org.softlang.maxmeffert.bscthesis.graphs.walkers.IGraphWalker;
import org.softlang.maxmeffert.bscthesis.graphs.walkers.IGraphWalkerFactory;
import org.softlang.maxmeffert.bscthesis.ioc.IoCGuiceModule;

public class Main {

	public static void main(String[] args) {
//		CCAnalyzer analyzer = CCAnalyzer.create();
//		analyzer.findCorrespondences("class A {class A {}}","");

		Injector injector = Guice.createInjector(new IoCGuiceModule());

		ITreeBuilderFactory treeBuilderFactory = injector.getInstance(ITreeBuilderFactory.class);
		ITree<Integer> tree = treeBuilderFactory.<Integer>newTreeBuilder()
				.withValue(1)
				.withChild(treeBuilderFactory.<Integer>newTreeBuilder()
					.withValue(2)
				)
				.withChild(treeBuilderFactory.<Integer>newTreeBuilder()
					.withValue(2)
				)
				.withChild(treeBuilderFactory.<Integer>newTreeBuilder()
					.withValue(2)
				)
				.build();

		System.out.println(tree.getRoot());
		System.out.println(tree.getChildrenOf(tree.getRoot()));

//		IGraphWalkerFactory graphWalkerFactory = injector.getInstance(IGraphWalkerFactory.class);
//		IGraphWalker<Integer> graphWalker = graphWalkerFactory.newGraphWalker();
//		graphWalker.walk();
	}

}
