package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

class DiGraphWalkerTest {

    @Test
    void test() {

        IGraphBuilder<Integer, DiGraph<Integer>> builder = DiGraph.Builder.get();
        builder.add(1,2);
        builder.add(2,3);
        builder.add(3,4);

        IDiGraph<Integer> diGraph = builder.build();

        DiGraphWalker<Integer> walker = new DiGraphWalker<>();

//        diGraph.getVertices().forEach(vertex -> closure(diGraph, vertex, vertex));

//        DiGraph.Builder<Integer> closureBuilder = DiGraph.Builder.get();
//
//        diGraph.getVertices().forEach(vertex -> {
//            for (int target : diGraph.getTargetsOf(vertex)) {
//                closureBuilder.add(vertex, target);
//            }
//        });
//
//        diGraph.getVertices().forEach(vertex -> {
//            walker.walkDepthFirst((IGraph<Integer>) diGraph, vertex, v -> {
//                if (!diGraph.getTargetsOf(v).contains(vertex)) {
//                    closureBuilder.add(vertex, v);
//                }
//            });
//        });

//        diGraph.closure();


        Consumer<Integer> print = source -> {
            for (int target : diGraph.getTargetsOf(source)) {
                System.out.println(source + " -> " + target);
            }
        };

//        walker.walkDepthFirst((IGraph<Integer>) diGraph, 1, print);


        System.out.println();
        DiGraph<Integer> closure = Graphs.transitiveClosureOf(diGraph, DiGraph.Builder::get);

//        walker.walkDepthFirst((IGraph<Integer>) closure, 1, print);

        IGraph<Integer> tc = TransitiveClosure.of(diGraph);


//        walker.walkDepthFirst((IGraph<Integer>) tc, 1, print);

        System.out.println(diGraph.getEdges());
        System.out.println(closure.getEdges());
        System.out.println(tc.getEdges());

        for (IPair<Integer, Integer> edge : closure.getEdges()) {
            Assertions.assertTrue(Graphs.transitiveClosureContainsEdge(diGraph, edge));
            Assertions.assertTrue(tc.containsEdge(edge));
        }

    }

}