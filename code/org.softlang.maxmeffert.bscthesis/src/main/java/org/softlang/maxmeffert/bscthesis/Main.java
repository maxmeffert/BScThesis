package org.softlang.maxmeffert.bscthesis;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.softlang.maxmeffert.bscthesis.graphs.IGraph;
import org.softlang.maxmeffert.bscthesis.graphs.IGraphBuilderFactory;
import org.softlang.maxmeffert.bscthesis.graphs.IGraphClosures;
import org.softlang.maxmeffert.bscthesis.ioc.IoCGuiceModule;

public class Main {

	public static void main(String[] args) {
		CCAnalyzer analyzer = CCAnalyzer.create();
		analyzer.findCorrespondences("class A {class A {}}","");

//		Injector injector = Guice.createInjector(new IoCGuiceModule());
//		IGraphBuilderFactory graphBuilderFactory = injector.getInstance(IGraphBuilderFactory.class);
//		IGraph<Integer> graph = graphBuilderFactory.<Integer>newGraphBuilder()
//				.withEdge(1,2)
//				.withEdge(1,3)
//				.withEdge(3,4)
//				.build();
//
//		IGraphClosures graphClosures = injector.getInstance(IGraphClosures.class);
//		IGraph<Integer> cGraph = graphClosures.reflexiveTransitiveClosureOf(graph);
//		System.out.println(cGraph.getAdjacentNodesOf(1));
 	}

}
