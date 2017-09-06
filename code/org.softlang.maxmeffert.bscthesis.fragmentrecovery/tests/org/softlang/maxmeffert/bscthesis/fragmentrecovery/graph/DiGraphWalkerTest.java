package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import org.junit.jupiter.api.Test;

class DiGraphWalkerTest {

    @Test
    void test() {

        DiGraph.Builder<Integer> builder = DiGraph.Builder.get();
        builder.add(1,2);
        builder.add(2,3);
        builder.add(2,4);

        DiGraph<Integer> diGraph = builder.build();

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



        walker.walkDepthFirst((IGraph<Integer>) diGraph, 1, source -> {
            for (int target : diGraph.getTargetsOf(source)) {
                System.out.println(source + " -> " + target);
            }
        });


        System.out.println();
        DiGraph<Integer> closure = Graphs.transitiveClosureOf(diGraph, DiGraph.Builder::get);

        walker.walkDepthFirst((IGraph<Integer>) closure, 1, source -> {
            for (int target : closure.getTargetsOf(source)) {
                System.out.println(source + " -> " + target);
            }
        });

        System.out.println(Graphs.copyOf(closure, DiGraph.Builder::get).getEdges());
    }

}