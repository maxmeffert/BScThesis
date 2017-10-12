package org.softlang.maxmeffert.bscthesis.ccrecovery;

public class Main {

	public static void main(String[] args) {
		CCRecovery ccRecovery = CCRecovery.create();
		ccRecovery.findCorrespondences("class A {class A {}}","");
//		analyzer.findCorrespondences("class A {}","");

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
