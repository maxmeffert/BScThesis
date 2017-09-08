package org.softlang.maxmeffert.bscthesis.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.softlang.maxmeffert.bscthesis.utils.IPair;

import java.util.Iterator;

class DiGraphWalkerTest {

    @Test
    void test() {

        IGraphBuilder<Integer, DiGraph<Integer>> builder = DiGraph.Builder.get();
        builder.add(1,2);
        builder.add(2,3);
//        builder.add(1,3);
//        builder.add(3,4);

        IGraph<Integer> diGraph = builder.build();
        IGraph<Integer> rtc1 = Graphs.reflexiveTransitiveClosureOf(diGraph, DiGraph.Builder::get);
        IGraph<Integer> rtc2 = ReflexiveTransitiveClosure.of(diGraph);

        System.out.println(diGraph+"");
        System.out.println(rtc1+"");
        System.out.println(rtc2+"");

        System.out.println(Graphs.reflexiveClosureOf(diGraph, DiGraph.Builder::get)+"");
        System.out.println(Graphs.transitiveClosureOf(diGraph, DiGraph.Builder::get)+"");

        for (IPair<Integer, Integer> edge : rtc1.getEdges()) {
            Assertions.assertTrue(Graphs.reflexiveTransitiveClosureContainsEdge(diGraph, edge));
            Assertions.assertTrue(rtc2.containsEdge(edge));
        }

        Iterator<Integer> it = DepthFirstIterator.of(diGraph, 1);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
        for (int i : new DepthFirstIterableGraph<>(diGraph, 1)) {
            System.out.println(i);
        }

    }

}