package org.softlang.maxmeffert.bscthesis.ccrecovery;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.CCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ccrecovery.ICCRecovery;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ICorrespondenceDefinition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.Java8Parser;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		ICCRecovery ccRecovery = CCRecovery.create();

		ILanguage java8 = ccRecovery.defineLanguage("Java8", Java8Lexer::new, Java8Parser::new, Java8Parser::compilationUnit);

		ICorrespondenceDefinition correspondenceDefinition = ccRecovery.defineCorrespondence()
				.withDomain(java8, java8)
				.iff((f1,f2) -> true)
				.build();

		ccRecovery.findCorrespondences(correspondenceDefinition,"class A {class A {}}","");
//		analyzer.findCorrespondences("class A {}","");

//		Injector injector = Guice.createInjector(new IoCConfig());
//		IGraphBuilderFactory graphBuilderFactory = injector.get(IGraphBuilderFactory.class);
//		IGraph<Integer> graph = graphBuilderFactory.<Integer>newGraphBuilder()
//				.withEdge(1,2)
//				.withEdge(1,3)
//				.withEdge(3,4)
//				.build();
//
//		IGraphClosures graphClosures = injector.get(IGraphClosures.class);
//		IGraph<Integer> cGraph = graphClosures.reflexiveTransitiveClosureOf(graph);
//		System.out.println(cGraph.getAdjacentNodesOf(1));
 	}

}
